package dzdc.core.query;



import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class ExchangeLogQuery  extends BaseQuery {


    private Integer uuid;
    //时间
    private DateTime dateTime;
    //兑换道具Id
    private String exchangePropsId;
    //消耗道具Id
    private String propsId;
    //消耗道具数量
    private Integer propsIdCount;
    //兑换数量
    private Integer count;

    //道具编码(一次赠送多张的话用逗号(,)隔开)
    private String serialNumber;

    private String orderNum;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date endDate;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getExchangePropsId() {
        return exchangePropsId;
    }

    public void setExchangePropsId(String exchangePropsId) {
        this.exchangePropsId = exchangePropsId;
    }

    public String getPropsId() {
        return propsId;
    }

    public void setPropsId(String propsId) {
        this.propsId = propsId;
    }

    public Integer getPropsIdCount() {
        return propsIdCount;
    }

    public void setPropsIdCount(Integer propsIdCount) {
        this.propsIdCount = propsIdCount;
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
