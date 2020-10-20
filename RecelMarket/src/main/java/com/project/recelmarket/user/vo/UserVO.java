package com.project.recelmarket.user.vo;

public class UserVO {
	private int i_user;
	private String user_id;
	private String user_pw;
	private String salt;
	private String nm;
	private String nickname;
	private String birthday;
	private String bir_yy;
	private String bir_mm;
	private String bir_dd;
	private String gender;
	private String email;
	private String profile_img;
	private String r_dt;
	private String m_dt;
	private String zip_cord;
	private String addr;
	private String AuthKey;
	
	
	public String getZip_cord() {
		return zip_cord;
	}
	public void setZip_cord(String zip_cord) {
		this.zip_cord = zip_cord;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getAuthKey() {
		return AuthKey;
	}
	public void setAuthKey(String authKey) {
		AuthKey = authKey;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBir_yy() {
		return bir_yy;
	}
	public void setBir_yy(String bir_yy) {
		this.bir_yy = bir_yy;
	}
	public String getBir_mm() {
		return bir_mm;
	}
	public void setBir_mm(String bir_mm) {
		this.bir_mm = bir_mm;
	}
	public String getBir_dd() {
		return bir_dd;
	}
	public void setBir_dd(String bir_dd) {
		this.bir_dd = bir_dd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
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
	
}
