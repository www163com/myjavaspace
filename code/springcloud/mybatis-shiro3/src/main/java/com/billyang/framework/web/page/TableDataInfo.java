package com.billyang.framework.web.page;

import java.util.List;

/**   
*    
* 项目名称：mybatis-shiro3   
* 类名称：TableDataInfo   
* 类描述：   分页数据
* 创建人：yangcan14944   
* 创建时间：2018-11-16 上午10:55:40   
* 修改人：yangcan14944   
* 修改时间：2018-11-16 上午10:55:40   
* 修改备注：   
* @version    
*    
*/
public class TableDataInfo {
	  private static final long serialVersionUID = 1L;
	    /** 总记录数 */
	    private long total;
	    /** 列表数据 */
	    private List<?> rows;

	    /**
	     * 表格数据对象
	     */
	    public TableDataInfo()
	    {
	    }

	    /**
	     * 分页
	     * 
	     * @param list 列表数据
	     * @param total 总记录数
	     */
	    public TableDataInfo(List<?> list, int total)
	    {
	        this.rows = list;
	        this.total = total;
	    }

	    public long getTotal()
	    {
	        return total;
	    }

	    public void setTotal(long total)
	    {
	        this.total = total;
	    }

	    public List<?> getRows()
	    {
	        return rows;
	    }

	    public void setRows(List<?> rows)
	    {
	        this.rows = rows;
	    }
}
