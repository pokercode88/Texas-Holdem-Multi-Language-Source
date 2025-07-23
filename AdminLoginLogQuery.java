package dzdc.core.query;

/**
 * 
* @ClassName: AdminLoginLogQuery
* @Description: TODO(这里用一句话描述这个类的作用)
* @author JohnnyChiu
* @date 2017年8月25日 上午9:49:44
*
 */
public class AdminLoginLogQuery {
    private String userName;
    private Integer pageIndex;
    private Integer pageSize;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
