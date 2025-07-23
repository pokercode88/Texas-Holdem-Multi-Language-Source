package dzdc.core.query;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StatisOnlineMatchesProfitQuery extends BaseQuery {


    //id
    private Integer id;
    //日期
    private String createDate;

    //报名次数
    private Integer enrollCount;

    //报名收入
    private Long  enrollProfit;

    //重购次数
    private Integer rebuyCount;

    //重购收入
    private Long  rebuyProfit;

    //增购次数
    private Integer addonCount;

    //增购收入
    private Long  addonProfit;

    //赛事
    private String matchesId;

    //区域
    private String AreaId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getEnrollCount() {
        return enrollCount;
    }

    public void setEnrollCount(Integer enrollCount) {
        this.enrollCount = enrollCount;
    }

    public Long getEnrollProfit() {
        return enrollProfit;
    }

    public void setEnrollProfit(Long enrollProfit) {
        this.enrollProfit = enrollProfit;
    }

    public Integer getRebuyCount() {
        return rebuyCount;
    }

    public void setRebuyCount(Integer rebuyCount) {
        this.rebuyCount = rebuyCount;
    }

    public Long getRebuyProfit() {
        return rebuyProfit;
    }

    public void setRebuyProfit(Long rebuyProfit) {
        this.rebuyProfit = rebuyProfit;
    }

    public Integer getAddonCount() {
        return addonCount;
    }

    public void setAddonCount(Integer addonCount) {
        this.addonCount = addonCount;
    }

    public Long getAddonProfit() {
        return addonProfit;
    }

    public void setAddonProfit(Long addonProfit) {
        this.addonProfit = addonProfit;
    }

    public String getMatchesId() {
        return matchesId;
    }

    public void setMatchesId(String matchesId) {
        this.matchesId = matchesId;
    }

    public String getAreaId() {
        return AreaId;
    }

    public void setAreaId(String areaId) {
        AreaId = areaId;
    }



}
