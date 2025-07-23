package dzdc.core.query;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class StatisEnrollOnlineQuery extends BaseQuery {


    private int id;
    //时间
    private String dateTime;
    //    赛事Id
    private String matchesId;

    //赛事场次
    private String matches;

    //区域Id
    private String AreaId;


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

    public String getMatchesId() {
        return matchesId;
    }

    public void setMatchesId(String matchesId) {
        this.matchesId = matchesId;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    @Override
    public String getAreaId() {
        return AreaId;
    }

    @Override
    public void setAreaId(String areaId) {
        AreaId = areaId;
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
