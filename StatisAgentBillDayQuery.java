package dzdc.core.query;

public class StatisAgentBillDayQuery extends BaseQuery {
    /* 游戏ID */
    private Long uid;
    /* 账号 */
    private String username;
    /* 昵称 */
    private String nickname;
    /* 上级代理ID */
    private Long recommendUid;
    /* 代理等级 */
    private Integer level;
    /* 搜索类型：1：默认 2：等级 */
    private Integer searchType;
    /** 商务代理最大等级 */
    private Integer maxLevel;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getRecommendUid() {
        return recommendUid;
    }

    public void setRecommendUid(Long recommendUid) {
        this.recommendUid = recommendUid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }
}
