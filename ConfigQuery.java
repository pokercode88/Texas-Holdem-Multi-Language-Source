package dzdc.core.query;

/**
 * Created by
 */

public class ConfigQuery extends  BaseQuery{

    //平台配置
    private int platId ;

    //游戏配置
    private String gameId;
    private String gameName;

    //房间配置
    private String roomId;
    private String roomName;

    //渠道配置
    private String channelName;

    //区域配置
    private String areaName;

    private Integer status;

    public int getPlatId() {
        return platId;
    }

    public void setPlatId(int platId) {
        this.platId = platId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
