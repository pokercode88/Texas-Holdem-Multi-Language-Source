package dzdc.core.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class SignUpLogDtoQuery extends BaseQuery {


    private int id;
    //时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private DateTime dateTime;

    //游戏账号系统的唯一id
    private Integer uuid;

    //赛事Id(房间)
    private String matchesId;
    //消耗道具Id
    private String propsId;
    //消耗道具数量
    private Integer count;

    private String serialNumber;

    private String matches;


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

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getMatchesId() {
        return matchesId;
    }

    public void setMatchesId(String matchesId) {
        this.matchesId = matchesId;
    }

    public String getPropsId() {
        return propsId;
    }

    public void setPropsId(String propsId) {
        this.propsId = propsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
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
