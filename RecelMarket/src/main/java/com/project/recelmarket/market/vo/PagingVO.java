package com.project.recelmarket.market.vo;

public class PagingVO {
	private int page;
	private int i_recel;
	private int pagingStart;
	private int pagingEnd;
	private int record_cnt;
	
	public int getRecord_cnt() {
		return record_cnt;
	}
	public void setRecord_cnt(int record_cnt) {
		this.record_cnt = record_cnt;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getI_recel() {
		return i_recel;
	}
	public void setI_recel(int i_recel) {
		this.i_recel = i_recel;
	}
	public int getPagingStart() {
		return pagingStart;
	}
	public void setPagingStart(int pagingStart) {
		this.pagingStart = pagingStart;
	}
	public int getPagingEnd() {
		return pagingEnd;
	}
	public void setPagingEnd(int pagingEnd) {
		this.pagingEnd = pagingEnd;
	}
}
