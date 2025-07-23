package dzdc.core.query;

public class StatisAgentGameFlowDayQuery extends BaseQuery {
    /** 房间ID */
    private String roomKey;
    /** 玩法 */
    private Integer gameType;
    /** 牌局名称*/
    private String roomName;
    /** 用户ID*/
    private Long uid;

    public String getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
