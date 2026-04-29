#ifndef _DB_OPERATOR_H_
#define _DB_OPERATOR_H_

#include <string>
#include <map>
#include <vector>

#include <util/tc_config.h>
#include <util/tc_mysql.h>
#include <util/tc_singleton.h>
#include <util/tc_autoptr.h>

///
#include <wbl/pthread_util.h>

#include "Order.pb.h"
#include "OrderServer.h"
#include "OuterFactoryImp.h"
//
using namespace std;
using namespace tars;
using namespace wbl;

typedef struct TCoinChangeRecord
{
    long Uid;
    int Type;
    int PropsId;
    long CoinCount;
    long CoinTotal;
    string Param;
    string CreateDate;
    TCoinChangeRecord(): Uid(0), Type(0), PropsId(0), CoinCount(0), CoinTotal(0), Param(""), CreateDate("")
    {
    }
} CoinChangeRecord;

/**
*
* DB操作类
*/
class CDBOperator : public TC_HandleBase
{
public:
    /**
     *
    */
    CDBOperator();

    /**
     *
    */
    ~CDBOperator();

public:
    /**
    * 初始化
    */
    int init();
    int init(const TC_DBConf &dbConf);
    int init(const string &dbhost, const string &dbuser, const string &dbpass,
             const string &dbname, const string &charset, const string &dbport);

public:
    //加载配置数据
    int loadConfig();

    int check_table_exist(const string& table_name);

    int select_coin_record(const string &strSQL, std::vector<TCoinChangeRecord>& result);

    string selectInOrderIDByOutOrderID(const string &outOrderID);

    int selectFlowRecordListByUid(const long uid, const orderProto::FlowRecordReq &req, orderProto::FlowRecordResp &resp);

    string selectUserName(const long uid);

    int selectAgencyBill(const long uid, const orderProto::AgencyBillReq &req,orderProto::AgencyBillResp& resp);

    int selectWalletAddress(const long uid, Json::Value &dataJson);

    int updateWalletAddress(const long uid, const string& address, const string& secret_key);

    long getUidByWalletAddress(const string& address);

private:
    wbl::ReadWriteLocker m_rwlock; //读写锁，防止数据脏读

private:
    TC_Mysql m_mysqlObj; //mysql操作对象
};

//singleton
typedef TC_Singleton<CDBOperator, CreateStatic, DefaultLifetime> DBOperatorSingleton;

//ptr
typedef TC_AutoPtr<CDBOperator> CDBOperatorPtr;

#endif


