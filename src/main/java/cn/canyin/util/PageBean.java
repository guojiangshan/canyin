package cn.canyin.util;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6244016222009755515L;
	/**
	 * 当前页(要显示页的num) begin 0
	 */
	private Integer currentPage=0;
	/**
	 * 每页显示行数
	 */
	private Integer perPageNum;
	
	/**
	 * 总页数
	 */
	private Integer countPage = 0;
	/**
	 * 总共条数
	 */
	private Long countRows=0l;
	/**
	 * 待显示的 数据
	 */
	private List<?> data;	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(Integer perPageNum) {
		this.perPageNum = perPageNum;
	}

	public Long getCountRows() {
		return countRows;
	}
	public void setCountRows(Long countRows) {
		this.countRows = countRows;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public Integer getCountPage() {
		if(countRows!=null && perPageNum!=null){
			int count = Integer.parseInt(  countRows.toString() );
			countPage =   (count % perPageNum)>0?(count/perPageNum+1):(count/perPageNum);
		}
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
}
