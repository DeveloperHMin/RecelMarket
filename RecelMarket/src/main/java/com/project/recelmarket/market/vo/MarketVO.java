package com.project.recelmarket.market.vo;

public class MarketVO {
	private int i_recel;
	private String title;
	private int cd_category;
	private int i_user;
	private int hits;
	private String r_dt;
	private String m_dt;
	private String ctnt;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getI_recel() {
		return i_recel;
	}
	public void setI_recel(int i_recel) {
		this.i_recel = i_recel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCd_category() {
		return cd_category;
	}
	public void setCd_category(int cd_category) {
		this.cd_category = cd_category;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
}
