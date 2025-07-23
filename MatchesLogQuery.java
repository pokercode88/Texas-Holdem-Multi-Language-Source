package dzdc.core.query;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import dzdc.core.bi.dto.BaseDto;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 牌局记录
 * @author: zhongwei
 * Date:2020年05月21日 14:30
 */
public class MatchesLogQuery extends BaseQuery{

	private int id;
	//时间
	@Excel(name="时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private DateTime dateTime;

	@Excel(name="用户Id")
	private Integer uuid;

	@Excel(name="系统平台标识（1：ios，2：android，3：h5）")
	private String platform;

	@Excel(name="渠道标识")
	private String channelId;

	@Excel(name="区域ID")
	private String areaId;

	@Excel(name="房间ID")
	private String roomId;

	@Excel(name="比赛场次")
	private String matches;

    @Excel(name="赢得积分")
    private String winPoints;

    @Excel(name="手牌")
    private String handCard;

    @Excel(name="公牌")
    private String publicCard;

    @Excel(name="本局牌型")
    private String cardType;

    @Excel(name="赢家牌型")
    private String winnerCardType;

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

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(String winPoints) {
        this.winPoints = winPoints;
    }

    public String getHandCard() {
        return handCard;
    }

    public void setHandCard(String handCard) {
        this.handCard = handCard;
    }

    public String getPublicCard() {
        return publicCard;
    }

    public void setPublicCard(String publicCard) {
        this.publicCard = publicCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getWinnerCardType() {
        return winnerCardType;
    }

    public void setWinnerCardType(String winnerCardType) {
        this.winnerCardType = winnerCardType;
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
