package dzdc.core.query;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class StatisRechargeLogQuery extends BaseQuery {
    private String roomId;
    private String uuid;
    private String userAccount;
    private String nickName;

    private String sdkOrderSn;
    private String productId;
    private List<Integer> goodList;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    // 当前登录账号是否是IOS平台账号
    private boolean platformIos;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSdkOrderSn() {
        return sdkOrderSn;
    }

    public void setSdkOrderSn(String sdkOrderSn) {
        this.sdkOrderSn = sdkOrderSn;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<Integer> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Integer> goodList) {
        this.goodList = goodList;
    }

    @Override
    public Date getStartDate() {
        if (startDate == null && uuid == null) {
            startDate = DateTime.now().minusDays(30).toDate();
        }
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        if (null == endDate && uuid == null) {
            endDate = DateTime.now().toDate();
        }
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isPlatformIos() {
        return platformIos;
    }

    public void setPlatformIos(boolean platformIos) {
        this.platformIos = platformIos;
    }
}
