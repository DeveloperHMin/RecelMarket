package com.project.recelmarket.user.jwt;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import com.project.recelmarket.user.vo.UserParam;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenMake {
	private static final String secretKey = "aasjjkjaskjdl1k2naskjkdakj34c8sa";
    
	public static String createToken(UserParam param){
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE,1); //만료일 1일

	    Claims claims = Jwts.claims()
	        .setSubject("access_token")
	        .setIssuedAt(new Date()); //생성일 설정

	    claims.put("key", param); //담고 싶은 값

	    String jwt = Jwts.builder()
	        .setHeaderParam("typ", "JWT")
	        .setClaims(claims)
	        .signWith(SignatureAlgorithm.HS256,  secretKey.getBytes())
	        .compact();

	    return jwt;
	}

	public static String getSubject(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
				.parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
