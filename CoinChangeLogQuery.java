package dzdc.core.query;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CoinChangeLogQuery extends BaseQuery {

    /** 自增Id */
    private Long id;

    /** 用户ID */
    private Long uid;

    /**物品ID**/
    private String propsId;
    /**场景**/
    private String type;

    /**变更数量**/
    private Long coinCount;
    /**变更后数量**/
    private Long coinTotal;

    private Long param;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    // 开始时间带时分秒
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTime1;

    // 结束时间带时分秒
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTime2;


    private Integer roomType;

    private String bagTypeId;

    /** 账号 */
    private String username;

    /** 昵称 */
    private String nickname;

    @Override
    public Date getStartDate() {
        return startDate;
    }
    @Override
    public Date getEndDate() {
        return endDate;
    }

    public Date getStartTime() {
        if (null == startTime) {
            startTime = DateTime.now().minusDays(30).toDate();
        }
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        if (null == endTime) {
            endTime = DateTime.now().toDate();
        }
        return endTime;
    }

    public Date getDateTime1() {
        return dateTime1;
    }

    public void setDateTime1(Date dateTime1) {
        this.dateTime1 = dateTime1;
    }

    public Date getDateTime2() {
        return dateTime2;
    }

    public void setDateTime2(Date dateTime2) {
        this.dateTime2 = dateTime2;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPropsId() {
        return propsId;
    }

    public void setPropsId(String propsId) {
        this.propsId = propsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Long coinCount) {
        this.coinCount = coinCount;
    }

    public Long getCoinTotal() {
        return coinTotal;
    }

    public void setCoinTotal(Long coinTotal) {
        this.coinTotal = coinTotal;
    }

    public Long getParam() {
        return param;
    }

    public void setParam(Long param) {
        this.param = param;
    }

    public String getBagTypeId() {
        return bagTypeId;
    }

    public void setBagTypeId(String bagTypeId) {
        this.bagTypeId = bagTypeId;
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
}
