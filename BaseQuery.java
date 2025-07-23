package dzdc.core.query;


import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public abstract class BaseQuery {

    private String areaId;
    private String areaName; //区域名称
    private Integer platform; //系统平台
    private String platformName; //系统平台名称
    private Integer rechargePlatform; //充值平台
    private String rechargePlatformName; //充值名称
    private String channelId;
    private String channelName;
    private String isinwhitelist; // 是否被冻结
    private Integer pageIndex;
    private Integer pageSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int statisType;//统计类别(1:日常， 2：周 ，3：月,4:时间范围)

    //默认查询30天
    public Date getStartDate() {
/*        if (null == startDate) {
            startDate = DateTime.now().minusDays(30).toDate();
        } else if (statisType == 1) {
            startDate = DateTime.now().minusDays(7).toDate();
        } else if (statisType == 2) {
            startDate = DateTime.now().minusDays(30).toDate();
        }*/
        if(startDate==null){
            startDate = DateTime.now().minusDays(30).toDate();
        }
        return startDate;
    }

    public void setStartDate(Date startDayTime) {
        this.startDate = startDayTime;
    }

    public Date getEndDate() {
       if (null == endDate) {
            endDate = DateTime.now().toDate();
        }
        return endDate;
    }

    public void setEndDate(Date endDayTime) {
        this.endDate = endDayTime;
    }


    public Integer getPageIndex() {
        if(pageIndex==null||pageIndex==0){
            pageIndex=1;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        if(pageIndex==null||pageIndex==0){
            pageIndex=1;
        }
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 30;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getStatisType() {
        return statisType;
    }

    public void setStatisType(int statisType) {
        this.statisType = statisType;
    }

    public Integer getRechargePlatform() {
        return rechargePlatform;
    }

    public void setRechargePlatform(Integer rechargePlatform) {
        this.rechargePlatform = rechargePlatform;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getRechargePlatformName() {
        return rechargePlatformName;
    }

    public void setRechargePlatformName(String rechargePlatformName) {
        this.rechargePlatformName = rechargePlatformName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getIsinwhitelist() {
        return isinwhitelist;
    }

    public void setIsinwhitelist(String isinwhitelist) {
        this.isinwhitelist = isinwhitelist;
    }
}
