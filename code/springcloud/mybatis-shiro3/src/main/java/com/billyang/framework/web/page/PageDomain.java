package com.billyang.framework.web.page;

import com.billyang.common.utils.StringUtils;


/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：PageDomain   
* 类描述：   分页数据
* 创建人：yangcan14944   
* 创建时间：2018-11-16 上午11:03:27   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 上午11:03:27   
* 修改备注：   
* @version    
*    
*/
public class PageDomain {
	//当前页数
	private Integer pageNum;
	//每页条数
	private Integer pageSize;
	//排序列
	private String orderByColumn;
	//排序方向   desc或者 asc
	private String isAsc;
	public String getOrderBy(){
		if(StringUtils.isEmpty(orderByColumn)){
			return "";
		}
		return orderByColumn + " " + isAsc;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderByColumn() {
		return orderByColumn;
	}
	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}
	public String getIsAsc() {
		return isAsc;
	}
	public void setIsAsc(String isAsc) {
		this.isAsc = isAsc;
	}
}
