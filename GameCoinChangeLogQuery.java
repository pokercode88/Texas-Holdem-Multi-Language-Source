package dzdc.core.query;

public class GameCoinChangeLogQuery extends BaseQuery {

    /** 用户ID */
    private Long uid;

    /** 玩法 */
    private Integer gameType;

    private String blindId;

    /** 小盲 */
    private Integer smallBlind;

    /** 大盲 */
    private Integer bigBlind;

    /** 前注 */
    private Integer frontBet;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getBlindId() {
        return blindId;
    }

    public void setBlindId(String blindId) {
        this.blindId = blindId;
    }

    public Integer getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    public Integer getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(Integer bigBlind) {
        this.bigBlind = bigBlind;
    }

    public Integer getFrontBet() {
        return frontBet;
    }

    public void setFrontBet(Integer frontBet) {
        this.frontBet = frontBet;
    }
}
