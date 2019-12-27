package org.lc.entity;

import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 */
public class Page implements Serializable {

	private static final long serialVersionUID = 8398165847129100984L;
	/**
	 * 1.页面大小
	 * 用户自定
	 */
	private Integer pageSize ;
	/**
	 * 2.当前页面
	 * 用户自定
	 */
	private Integer currentPage;
	/**
	 * 3.页面总数
	 * 计算所得
	 */
	private Integer totalPage;

	/**
	 * 4.数据总数
	 * 查数据库 select count（*）
	 */
	private Integer totalCount;
	/**
	 * 5.数据集合
	 * 查数据库
	 */
	@SuppressWarnings("unused")
	List<User> list;

	/**
	 * 开始查询的数据位置
	 */
	@SuppressWarnings("unused")
	private Integer startPos;
	/**
	 *
	 * 	 * ** startPos=（currentPage-1）*pageSize
	 * 	 * ** select * from tb_user limit  startPos, pageSize
	 * 	 * ** totalPage=数据总数%页面大小==0?数据总数/页面大小:数据总数/页面大小	+1
	 */
	/**
	 *
	 * select * from tb_user limit  开始数据, 数据量
	 * select * from tb_user limit  0, 2  	第一页
	 * select * from tb_user limit  2, 2	第二页
	 * select * from tb_user limit  4, 2	第三页
	 * select * from tb_user limit  （currentPage-1）*pageSize, pageSize
	 * ** startPos=（currentPage-1）*pageSize
	 * ** select * from tb_user limit  startPos, pageSize
	 * totalPage=数据总数/页面大小     4/2=2
	 * totalPage=数据总数/页面大小		5/2=2 需要 5/2=3
	 * if(数据总数%页面大小!=0){
	 *     totalPage=数据总数/页面大小	+1
	 * }else{
	 *     totalPage=数据总数/页面大小
	 * }
	 * ** totalPage=数据总数%页面大小==0?数据总数/页面大小:数据总数/页面大小	+1
	 */

	/**
	 * 通过构造函数 传入  总数据数  和  当前页  和  页面大小
	 * @param totalCount
	 * @param currentPage
	 * @param pageSize
	 */
	public Page(int totalCount, int currentPage,int pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	/**
	 * @param totalCount
	 * @param currentPage
	 */
	public Page(int totalCount, int currentPage) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
	}
	/**
	 * 取得总页数，总页数=总记录数/每页显示记录的条数
	 * @return
	 */
	public Integer getTotalPage() {
		totalPage = getTotalCount() / getPageSize();
		return (totalCount % pageSize == 0) ? totalPage : totalPage + 1;
		//return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	/**
	 * 取得选择记录的初始位置
	 * @return
	 */
	public int getStartPos() {
		return (currentPage - 1) * pageSize;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	@Override
	public String toString() {
		return "Page{" +
				"pageSize=" + pageSize +
				", currentPage=" + currentPage +
				", totalPage=" + totalPage +
				", totalCount=" + totalCount +
				'}';
	}
}
