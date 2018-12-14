package util;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("all")
@Getter
@ToString
// 分页的结果集对象：封装了所有的分页信息
public class PageResult {
	private List listData;// 当前页的结果集：通过SQL查询出来的
	private Integer totalCount;// 结果总数，通过SQL查询出来的
	private Integer currentPage = 1;// 当前页
	private Integer pageSize = 10;// 每页最多显示多少条数据
	private Integer beginPage = 1;// 首页
	private Integer prevPage;// 上页
	private Integer nextPage;// 下页
	private Integer totalPage;// 末页/总页数
	private Integer beginIndex;
	private Integer endIndex;

	public PageResult(List listData, Integer totalCount, Integer currentPage,
			Integer pageSize) {
		super();
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		// ================================================
		// 总页数/末页(totalPage)
		this.totalPage = this.totalCount % this.pageSize == 0 ? 
				         this.totalCount / this.pageSize: 
				         this.totalCount / this.pageSize + 1;
		// 上一页(prevPage)
		this.prevPage = this.currentPage - 1 >= 1 ? 
				        this.currentPage - 1 : 1;
		// 下一页(nextPage)
		this.nextPage = this.currentPage + 1 <= this.totalPage ? 
				        this.currentPage + 1: this.totalPage;
		
		//获取页码的开始和结束索引
		PageIndex pageIndex = PageIndex.getPageIndex(5, currentPage, this.totalPage);
		this.beginIndex = pageIndex.getBeginIndex();
		this.endIndex = pageIndex.getEndIndex();
	}

}
