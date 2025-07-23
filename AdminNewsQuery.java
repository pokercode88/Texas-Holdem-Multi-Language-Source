package dzdc.core.query;

/**
 * Created by lghyt on 2017/6/16.
 */
public class AdminNewsQuery extends BaseQuery {
    private Integer gameId;
    private String uid;
    private String title;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
