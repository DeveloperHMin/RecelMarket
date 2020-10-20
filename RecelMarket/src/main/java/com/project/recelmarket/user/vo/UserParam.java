package com.project.recelmarket.user.vo;

public class UserParam extends UserVO{
	private int authstatus;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getAuthstatus() {
		return authstatus;
	}

	public void setAuthstatus(int authstatus) {
		this.authstatus = authstatus;
	}

}
