package dzdc.core.query;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class SeasonRankRewardLogQuery extends BaseQuery {

    //用来控制是否显示奖励字段
    private int type;

    private int id;
    //时间
    private String dateTime;
    //区域Id
    private String AppId;

    //赛季
    private String season;
    //用户id
    private String uuid;
    //段位
    private String grade;
    //星数
    private String star;

    //赛季排名
    private String rank;

    //段位奖励
    private String reward;
    //领取日期
    private String date;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }


    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
