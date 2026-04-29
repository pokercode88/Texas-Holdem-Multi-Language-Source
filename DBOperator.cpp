#include <sstream>
#include <util/tc_common.h>
#include "DBOperator.h"
#include "globe.h"
#include "LogComm.h"
#include "Processor.h"

//
using namespace wbl;

/**
 *
*/
CDBOperator::CDBOperator()
{

}

/**
 *
*/
CDBOperator::~CDBOperator()
{

}

//初始化
int CDBOperator::init()
{
    FUNC_ENTRY("");

    int iRet = 0;

    try
    {
        //for test
        map<string, string> mpParam;
        mpParam["dbhost"]  = "localhost";
        mpParam["dbuser"]  = "tars";
        mpParam["dbpass"]  = "tars2015";
        mpParam["dbname"]  = "config";
        mpParam["charset"] = "utf8";
        mpParam["dbport"]  = "3306";

        TC_DBConf dbConf;
        dbConf.loadFromMap(mpParam);

        //初始化数据库连接
        m_mysqlObj.init(dbConf);
    }
    catch (exception &e)
    {
        iRet = -1;
        ROLLLOG_ERROR << "Catch exception: " << e.what() << endl;
    }
    catch (...)
    {
        iRet = -2;
        ROLLLOG_ERROR << "Catch unknown exception." << endl;
    }

    FUNC_EXIT("", iRet);
    return iRet;
}

//初始化
int CDBOperator::init(const string &dbhost, const string &dbuser, const string &dbpass, const string &dbname, const string &charset, const string &dbport)
{
    FUNC_ENTRY("");

    int iRet = 0;

    try
    {
        map<string, string> mpParam;
        mpParam["dbhost"]  = dbhost;
        mpParam["dbuser"]  = dbuser;
        mpParam["dbpass"]  = dbpass;
        mpParam["dbname"]  = dbname;
        mpParam["charset"] = charset;
        mpParam["dbport"]  = dbport;

        TC_DBConf dbConf;
        dbConf.loadFromMap(mpParam);

        m_mysqlObj.init(dbConf);
    }
    catch (exception &e)
    {
        iRet = -1;
        ROLLLOG_ERROR << "Catch exception: " << e.what() << endl;
    }
    catch (...)
    {
        iRet = -2;
        ROLLLOG_ERROR << "Catch unknown exception." << endl;
    }

    FUNC_EXIT("", iRet);

    return iRet;
}

//初始化
int CDBOperator::init(const TC_DBConf &dbConf)
{
    FUNC_ENTRY("");

    int iRet = 0;

    try
    {
        //初始化数据库连接
        m_mysqlObj.init(dbConf);
    }
    catch (exception &e)
    {
        iRet = -1;
        ROLLLOG_ERROR << "Catch exception: " << e.what() << endl;
    }
    catch (...)
    {
        iRet = -2;
        ROLLLOG_ERROR << "Catch unknown exception." << endl;
    }

    FUNC_EXIT("", iRet);

    return iRet;
}

int CDBOperator::check_table_exist(const string& table_name)
{
    FUNC_ENTRY("");

    WriteLocker lock(m_rwlock);

    try
    {
        string strSQL = "select `TABLE_NAME` from information_schema.tables where table_schema='dzdc_bi' and table_name ='" + table_name + "';";
        TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(strSQL);
        //ROLLLOG_DEBUG << "Execute SQL: [" << strSQL << "], return " << res.size() << " records." << endl;

        return res.size() == 1;
    }
    catch (TC_Mysql_Exception &e)
    {
        //ROLLLOG_DEBUG << "select operator catch mysql exception: " << e.what() << endl;
        return false;
    }
    catch (...)
    {
        ROLLLOG_DEBUG << "select operator catch unknown exception." << endl;
        return false;
    }

    FUNC_EXIT("", 0);
    return false;
}

int CDBOperator::select_coin_record(const string &strSQL, std::vector<TCoinChangeRecord>& result)
{
    FUNC_ENTRY("");

    WriteLocker lock(m_rwlock);

    int iRet = 0;
    try
    {
        TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(strSQL);
        ROLLLOG_DEBUG << "Execute SQL: [" << strSQL << "], return " << res.size() << " records." << endl;

        for (size_t i = 0; i < res.size(); ++i)
        {
            TCoinChangeRecord record;
            record.Uid = TC_Common::strto<long>(res[i]["Uid"]);
            record.Type = TC_Common::strto<int>(res[i]["Type"]);
            record.CoinCount = TC_Common::strto<long>(res[i]["CoinCount"]);
            record.CoinTotal = TC_Common::strto<long>(res[i]["CoinTotal"]);
            record.PropsId = TC_Common::strto<long>(res[i]["PropsId"]);
            record.Param = res[i]["Param"];
            record.CreateDate = res[i]["CreateDate"];
            result.push_back(record);
        }
    }
    catch (TC_Mysql_Exception &e)
    {
        //ROLLLOG_DEBUG << "select operator catch mysql exception: " << e.what() << endl;
        iRet = -1;
    }
    catch (...)
    {
        ROLLLOG_DEBUG << "select operator catch unknown exception." << endl;
        iRet = -2;
    }

    FUNC_EXIT("", iRet);
    return iRet;
}

int CDBOperator::selectFlowRecordListByUid(const long uid, const orderProto::FlowRecordReq &req, orderProto::FlowRecordResp &resp)
{
    LOG_DEBUG << "req: "<< logPb(req)<< endl;

    std::vector<int> vecTypeList;
    vecTypeList.insert(vecTypeList.begin(), req.vectype().begin(), req.vectype().end());
    if(vecTypeList.empty())
    {
        g_app.getOuterFactoryPtr()->getFlowRecordTypeList(-1, vecTypeList);
    }
    
    if(vecTypeList.empty())
    {
        LOG_ERROR << "vecTypeList is empty. " << endl;
        return 0;
    }

    std::ostringstream os;
    os<< "Type in (";
    for(unsigned int i = 0; i < vecTypeList.size(); i++)
    {
        os << vecTypeList[i];
        if(i < vecTypeList.size() - 1)
        {
            os << ",";
        }
    }
    os << ") order by CreateDate desc;";


    int day = g_app.getOuterFactoryPtr()->GetMonthDays(g_app.getOuterFactoryPtr()->GetTimeFormat()) -1;

    int diff_days = g_app.getOuterFactoryPtr()->GetTimeDays();
    int idays = req.idays() == -1 || req.idays() > diff_days ? diff_days : req.idays();

    string table_name = "coin_change_log";
    string select_date = g_app.getOuterFactoryPtr()->GetTimeDayLater(idays);

    vector<string> vecSql;
    if(idays > day)//跨月
    {
        set<string> sMonth;
        for(int i = 1; i <= idays; i++)
        {
            sMonth.insert(g_app.getOuterFactoryPtr()->GetTimeMonthLater(i));
        }

        for(auto month : sMonth)
        {
            string new_table_name = table_name+ month;

            if(!check_table_exist(new_table_name))
            {
                continue;
            }

            string SQL = "select `CreateDate`, `Uid`, `Type`, `PropsId`, `CoinCount`, `CoinTotal`, `Param` from `dzdc_bi`." + new_table_name + " where Uid =" + L2S(uid) + " and `CreateDate` >= '" + select_date + "' and " + os.str() ;
            vecSql.push_back(SQL);
        }
    }
    string SQL = "select `CreateDate`, `Uid`, `Type`, `PropsId`, `CoinCount`, `CoinTotal`, `Param` from `dzdc_bi`." + table_name + " where Uid =" + L2S(uid) + " and `CreateDate` >= '" + select_date + "' and " + os.str() ;
    vecSql.push_back(SQL);

    std::vector<TCoinChangeRecord> coin_records;
    for(auto sSql : vecSql)
    {
        //ROLLLOG_DEBUG << "sSql: " << sSql << endl;
        select_coin_record(sSql, coin_records);
    }

    std::sort(coin_records.begin(), coin_records.end(), [](TCoinChangeRecord l, TCoinChangeRecord r)->bool{
        return l.CreateDate > r.CreateDate;
    });

    map<long, userinfo::GetUserBasicResp> mapUserInfo;

    // 选取需要显示的记录数
    unsigned int start_index = (req.ipage() - 1) * g_app.getOuterFactoryPtr()->getLimitRecord();
    start_index = start_index <= 0 ? 0 : (start_index > coin_records.size() ? coin_records.size() : start_index);
    unsigned int end_index = start_index + g_app.getOuterFactoryPtr()->getLimitRecord();
    end_index = end_index > coin_records.size() ? coin_records.size() : end_index;
    for(unsigned int i = start_index; i < end_index; i++)
    {   
        auto prt = resp.add_record_list();

        long time_second = g_app.getOuterFactoryPtr()->convertTimeStr2TimeStamp(coin_records[i].CreateDate);
        prt->set_optiontime(L2S(time_second));
        prt->set_ichangetype(coin_records[i].Type);
        prt->set_ichanneltype( ProcessorSingleton::getInstance()->getWalletChannelType(coin_records[i].Param));
        prt->set_lamount(coin_records[i].CoinCount);
        prt->set_lcurrentcoin(coin_records[i].CoinTotal);
        prt->set_ipropsid(coin_records[i].PropsId);

        if(vecTypeList.size() == 2)//目前只有资金转入的情况需要用户信息
        {
            auto it = mapUserInfo.find(S2L(coin_records[i].Param));
            if(it == mapUserInfo.end())
            {
                userinfo::GetUserBasicReq basicReq;
                basicReq.uid = S2L(coin_records[i].Param);
                userinfo::GetUserBasicResp basicResp;
                int iRet = g_app.getOuterFactoryPtr()->getHallServantPrx(basicReq.uid)->getUserBasic(basicReq, basicResp);
                if (iRet != 0)
                {
                    ROLLLOG_ERROR << " getUserBasic err. iRet:  " << iRet  << endl;
                    continue;
                }
                mapUserInfo.insert(std::make_pair(basicReq.uid, basicResp));
                it = mapUserInfo.find(S2L(coin_records[i].Param));
            }

            if(it != mapUserInfo.end())
            {
                prt->set_snickname(it->second.userinfo.name);
                prt->set_sheadurl(it->second.userinfo.head);
                prt->set_lplayerid(S2L(coin_records[i].Param));
            }

        }

    }   

    resp.set_record_count(coin_records.size());
    resp.set_show_count(g_app.getOuterFactoryPtr()->getLimitRecord());
    return 0;
}

string CDBOperator::selectInOrderIDByOutOrderID(const string &outOrderID)
{
    ROLLLOG_DEBUG<< "outOrderID: "<< outOrderID << endl;
    WriteLocker lock(m_rwlock);
    try
    {
        string strSQL = "select `inOrderID` from `tb_wallet_order` where `outOrderID` != '' and  `outOrderID` = '" + outOrderID + "';";
        TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(strSQL);
        ROLLLOG_DEBUG << "Execute SQL: [" << strSQL << "], return " << res.size() << " records." << endl;

        for (size_t i = 0; i < res.size(); ++i)
        {
            return res[i]["inOrderID"];
        }
    }
    catch (TC_Mysql_Exception &e)
    {
        return "";
    }
    catch (...)
    {
        ROLLLOG_DEBUG << "select operator catch unknown exception." << endl;
        return "";
    }
    return "";
}

string CDBOperator::selectUserName(const long uid)
{
    string strSql = "select nickname from `dz_game`.`tb_userinfo` where `uid` = " + L2S(uid) + ";";
    TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(strSql);
    ROLLLOG_DEBUG << "Execute SQL: [" << strSql << "], return " << res.size() << " records." << endl;

    if(res.size() != 1)
    {
        return "";
    }
    return res[0]["nickname"];
}

int CDBOperator::selectAgencyBill(const long uid, const orderProto::AgencyBillReq &req,orderProto::AgencyBillResp& resp)
{
    std::ostringstream os;
    os<< "SELECT `uid` as lPlayerID, sum(a.`buyIn`) as lBuyIn, sum(a.`insureBuy`) as lInsureBuy, sum(a.`insurePay`) as lInsurePay, sum(a.`fees`) as lInsureFee, a.`bindTime` as sBindTime FROM `dzdc_bi`.`statis_agent_bill_day` AS a WHERE `uid` IN (SELECT `uid` FROM `dz_game`.`tb_recommend` WHERE recommend_uid = ";
    os << uid << ") AND a.`date` <= '" << req.enddate() << "' AND a.`date` >= '"<< req.startdate() << "' GROUP BY a.`uid`";

    try
    {
        TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(os.str());
        ROLLLOG_DEBUG << "Execute SQL: [" << os.str() << "], return " << res.size() << " records." << endl;


        unsigned int start_index = (req.ipage() - 1) * g_app.getOuterFactoryPtr()->getLimitRecord();
        start_index = start_index <= 0 ? 0 : (start_index > res.size() ? res.size() : start_index);
        unsigned int end_index = start_index + g_app.getOuterFactoryPtr()->getLimitRecord();
        end_index = end_index > res.size() ? res.size() : end_index;
        for(unsigned int i = start_index; i < end_index; i++)
        {
            auto ptr = resp.add_data();
            ptr->set_lplayerid(TC_Common::strto<long>(res[i]["lPlayerID"]));
            ptr->set_snickname(selectUserName(ptr->lplayerid()));
            ptr->set_lbuyin(TC_Common::strto<long>(res[i]["lBuyIn"]));
            ptr->set_linsurebuy(TC_Common::strto<long>(res[i]["lInsureBuy"]));
            ptr->set_linsurepay(TC_Common::strto<long>(res[i]["lInsurePay"]));
            ptr->set_linsurefee(TC_Common::strto<long>(res[i]["lInsureFee"]));
            ptr->set_sbindtime(res[i]["sBindTime"]);
        }

        resp.set_record_count(res.size());
        resp.set_curr_page(req.ipage());
        resp.set_show_count(g_app.getOuterFactoryPtr()->getLimitRecord());

    }
    catch (TC_Mysql_Exception &e)
    {
        ROLLLOG_DEBUG << "select operator catch mysql exception: " << e.what() << endl;
        return -1;
    }
    catch (...)
    {
        ROLLLOG_DEBUG << "select operator catch unknown exception." << endl;
        return -2;
    }

    return 0;
}

int CDBOperator::selectWalletAddress(const long uid, Json::Value &dataJson)
{
    std::ostringstream os;
    os<< "select `uid`, `address`, `secret_key` from `dzdc_bi`.`user_wallet` where `uid` = " + L2S(uid) + ";";

    try
    {
        TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(os.str());
        ROLLLOG_DEBUG << "Execute SQL: [" << os.str() << "], return " << res.size() << " records." << endl;

        if(res.size() != 1)
        {
            return 0;
        }

        dataJson["fromAddress"] = res[0]["address"];
        dataJson["privateKey"] = res[0]["secret_key"];
    }
    catch (TC_Mysql_Exception &e)
    {
        ROLLLOG_DEBUG << "select operator catch mysql exception: " << e.what() << endl;
        return -1;
    }
    catch (...)
    {
        ROLLLOG_DEBUG << "select operator catch unknown exception." << endl;
        return -2;
    }

    return 0;
}

int CDBOperator::updateWalletAddress(const long uid, const string& address, const string& secret_key)
{
    std::ostringstream os;
    //os << "INSERT INTO `dzdc_bi`.`user_wallet` (`uid`, `address`, `secret_key`) VALUES (" << uid << ", '"<< address << "', '"<< secret_key << "') ON DUPLICATE KEY UPDATE `address`='" << address << "', `secret_key` ='"<< secret_key<< "';";
    os << "INSERT INTO `dzdc_bi`.`user_wallet` (`uid`, `address`, `secret_key`) VALUES (" << uid << ", '"<< address << "', '"<< secret_key << "') ON DUPLICATE KEY UPDATE `address`='" << address << "';";

    try
    {
        m_mysqlObj.execute(os.str());
        ROLLLOG_DEBUG << "Execute SQL: [" << os.str() << "], , effect count " << m_mysqlObj.getAffectedRows() << endl;
    }
    catch (TC_Mysql_Exception &e)
    {
        ROLLLOG_DEBUG << "select operator catch mysql exception: " << e.what() << endl;
        return -1;
    }
    catch (...)
    {
        ROLLLOG_DEBUG << "select operator catch unknown exception." << endl;
        return -2;
    }

    return 0;
}

long CDBOperator::getUidByWalletAddress(const string& address)
{
    string strSql = "select `uid` from `dzdc_bi`.`user_wallet` where `address` = '" + address + "';";
    TC_Mysql::MysqlData res = m_mysqlObj.queryRecord(strSql);
    ROLLLOG_DEBUG << "Execute SQL: [" << strSql << "], return " << res.size() << " records." << endl;

    if(res.size() != 1)
    {
        return 0;
    }
    return TC_Common::strto<long>(res[0]["uid"]);
}

//加载配置数据
int CDBOperator::loadConfig()
{
    FUNC_ENTRY("");

    int iRet = 0;

    FUNC_EXIT("", iRet);

    return iRet;
}

