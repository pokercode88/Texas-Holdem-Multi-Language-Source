package dzdc.core.query;

public class SafesChangeLogQuery extends BaseQuery {

    /**
     * 用户iD
     */
    private Long uid;

    /**
     * 操作类型 0存入 1取出
     */
    private Integer operateType;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
}
