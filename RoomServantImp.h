#ifndef _RoomServantImp_H_
#define _RoomServantImp_H_

#include "servant/Application.h"
#include "RoomServant.h"
#include "OuterFactoryImp.h"
#include "TimerThread.h"

/**
 * 服务接口
 */
class RoomServantImp : public JFGame::RoomServant
{
public:
    /**
     *
     */
    RoomServantImp() {}

    /**
     *
     */
    virtual ~RoomServantImp() {}

    /**
     * 初始化
     */
    virtual void initialize();

    /**
     * 销毁
     */
    virtual void destroy();

public:
    /**
     * 处理终端请求
     */
    virtual tars::Int32 onRequest(tars::Int64 lUin, const std::string &sMsgPack, const std::string &sCurServrantAddr,
                                  const JFGame::TClientParam &stClientParam, const JFGame::UserBaseInfoExt &stUserBaseInfo, tars::TarsCurrentPtr current);

    /**
     * 玩家断线接口
     */
    virtual tars::Int32 onOffline(tars::Int64 lUin, const std::string &sRoomID, bool stanup, tars::TarsCurrentPtr current);

    /**
     * java通知消息
     */
    virtual tars::Int32 notifyRoom(const java2room::NotifyRoomReq &req, tars::TarsCurrentPtr current);

    /**
     * 拉取房间奖池数据
    */
    virtual tars::Int32 onLoadPrizePool(const string &roomid, tars::TarsCurrentPtr current);

    // 俱乐部房间批量加入或退出机器人
    virtual tars::Int32 onEnterOrExitRoom(const java2room::EnterOrExitRoomReq &req, java2room::EnterOrExitRoomResp &resp, tars::TarsCurrentPtr current);

    // 俱乐部创建桌子
    virtual tars::Int32 onCreatePrTable(const java2room::CreateTableReq &req, java2room::CreateTableResp &resp, tars::TarsCurrentPtr current);

    // 房间创建人审核申请带入
    virtual tars::Int32 onRoomAuditApply(const java2room::RoomAuditApplyReq &req, tars::TarsCurrentPtr current);

    //同步玩家信息
    virtual tars::Int32 updateUserInfo2Room(tars::Int64 lUin, tars::TarsCurrentPtr current);
public:
    /**
     * 游戏定时器处理主先循环
     */
    virtual tars::Int32 doCustomMessage(bool bExpectIdle = false);

public:
    //
    int checkOnline(const long lPlayerID, const HeadInfo &stHeadInfo);
    //
    int doLoginReq(long lPlayerID, const short nMsgID, const HeadInfo &stHeadInfo);
    //
    int doLoginReq(long lPlayerID, const string sRoomID, const short nMsgID, const vector<char> &vecMsgData, const HeadInfo &stHeadInfo,
                   const JFGame::TClientParam &stClientParam, const JFGame::UserBaseInfoExt &stUserBaseInfo);
    //
    int toClientLoginMsg(const long lPlayerID, const short nMsgID, const int iRetCode);
    //
    int doRequest(long lPlayerID, const string sRoomID, const short nMsgID, const vector<char> &vecMsgData,
                  const JFGame::TClientParam &stClientParam, const JFGame::UserBaseInfoExt &stUserBaseInfo);

    int doCfgMessageReq(long lPlayerID, const string sRoomID, const short nMsgID, const vector<char> &vecMsgData, const HeadInfo &stHeadInfo,const JFGame::TClientParam &stClientParam, const JFGame::UserBaseInfoExt &stUserBaseInfo);
    //
    int onGetTableList(long lPlayerID, const string sRoomID, const short nMsgID, const vector<char> &vecMsgData, const HeadInfo &stHeadInfo,const JFGame::TClientParam &stClientParam, const JFGame::UserBaseInfoExt &stUserBaseInfo);
    //
    void ActiveTimer();
    //
    void CheckTimer();

private:
    //
    void getDealCards();
    //
    void initializeTimer();

private:
    /**
    * 定时器线程
    */
    TimerThread m_threadTimer;

    /**
    * 定时器标记
    */
    bool m_bIsSetTimer;
};
/////////////////////////////////////////////////////
#endif


