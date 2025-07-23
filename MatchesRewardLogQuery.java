package dzdc.core.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MatchesRewardLogQuery extends BaseQuery {

    private String roomId;

    private String  uuid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date endDate;

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
