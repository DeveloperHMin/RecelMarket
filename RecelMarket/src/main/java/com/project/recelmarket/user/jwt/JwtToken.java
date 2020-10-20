package com.project.recelmarket.user.jwt;

import com.project.recelmarket.user.vo.UserVO;

public class JwtToken {
	public static String genToken(UserVO param) {
		String token = JwtTokenMake.createToken(param);
		return token;
	}

	public String getSubject(String token) {
		String subject = JwtTokenMake.getSubject(token);
		return subject;
	}
}
