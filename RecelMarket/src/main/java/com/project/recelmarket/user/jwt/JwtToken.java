package com.project.recelmarket.user.jwt;

import com.project.recelmarket.user.vo.UserParam;

public class JwtToken {
	public String genToken(UserParam param) {
		String token = JwtTokenMake.createToken(param);
		return token;
	}

	public String getSubject(String token) {
		String subject = JwtTokenMake.getSubject(token);
		return subject;
	}
}
