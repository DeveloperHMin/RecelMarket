package com.project.recelmarket.market.vo;

import java.util.List;

public class MarketParam extends MarketVO{
	private int cm_category;
	private int cd_category;
	private int i_user;
	private String recel_pic;
	private String nickname;
	private String profile_img;
	private String cm_nm;
	private String cd_nm;
	private int record_cnt;
	private List<MarketParam> list;
	private int page;
	
	
	public int getRecord_cnt() {
		return record_cnt;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<MarketParam> getList() {
		return list;
	}
	public void setList(List<MarketParam> list) {
		this.list = list;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getCm_nm() {
		return cm_nm;
	}
	public void setCm_nm(String cm_nm) {
		this.cm_nm = cm_nm;
	}
	public String getCd_nm() {
		return cd_nm;
	}
	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}
	public String getRecel_pic() {
		return recel_pic;
	}
	public void setRecel_pic(String recel_pic) {
		this.recel_pic = recel_pic;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getCm_category() {
		return cm_category;
	}
	public void setCm_category(int cm_category) {
		this.cm_category = cm_category;
	}
	public int getCd_category() {
		return cd_category;
	}
	public void setCd_category(int cd_category) {
		this.cd_category = cd_category;
	}
}
