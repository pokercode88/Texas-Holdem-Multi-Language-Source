package dzdc.core.query;

/**
 * 比赛排名奖励记录
 * @author: zhongwei
 * Date:2020年05月21日 14:30
 */
public class ExchangeCodeLogQuery extends BaseQuery {


	//时间
	private Integer id;

	private String code;

	private Long exchangeConfigId;

	private Integer createId;

	private Integer count;

	private String createDate;

	private Long uid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getExchangeConfigId() {
		return exchangeConfigId;
	}

	public void setExchangeConfigId(Long exchangeConfigId) {
		this.exchangeConfigId = exchangeConfigId;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
}
