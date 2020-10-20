package com.project.recelmarket.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.recelmarket.Const;
import com.project.recelmarket.SecurityUtils;
import com.project.recelmarket.user.vo.UserParam;
import com.project.recelmarket.user.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	
	//insert
	//회원가입
	@Transactional
	public void joinProc(UserVO param) {
		String pw = param.getUser_pw();
		String salt = SecurityUtils.generateSalt();
		String cryptPw = SecurityUtils.getEncrypt(pw, salt);
		String yy = param.getBir_yy();
		String dd = param.getBir_dd();
		String mm = param.getBir_mm();
		String birthday = yy + mm + dd;
		
		param.setBirthday(birthday);
		param.setSalt(salt);
		param.setUser_pw(cryptPw);

		System.out.println("nm" + param.getNickname());
		System.out.println(birthday);
		mapper.insUser(param);
		mapper.delEmail(param);
	}
	
	//이메일 등록
	public int signUp(UserVO param) {
		return mapper.ins_singUp(param);

	}
	
	
	//update
	//인증키 등록
	public int updateAuthKey(UserVO param) {
		return mapper.upd_AuthKey(param);

	}

	//인증확인
	public int updateAuthStatus(UserVO param) {
		return mapper.upd_AuthStatus(param);

	}
	
	
	//select
	//아이디 체크
	public int login(UserVO param) {
		if (param.getUser_id().equals("")) {
			return Const.NO_ID;
		}

		UserVO dbUser = mapper.selUser(param);
		if (dbUser == null) {
			return Const.NO_ID;
		}

		String cryptPw = SecurityUtils.getEncrypt(param.getUser_pw(), dbUser.getSalt());
		if (!cryptPw.equals(dbUser.getUser_pw())) {
			return Const.NO_PW;
		}

		param.setI_user(dbUser.getI_user());
		param.setUser_pw(null);
		param.setNm(dbUser.getNm());
		param.setNickname(dbUser.getNickname());
		param.setProfile_img(dbUser.getProfile_img());
		return Const.SUCCESS;
	}


	public int selAuth(UserParam param) {
		UserParam dbUser = mapper.selEmail(param);
		if(dbUser.getAuthstatus() == 0){ // 이메일 인증을 안함
			return Const.NO_AUTHSTATUS;
		}else { //가입되있는 이메일이다.
			return Const.SUCCESS;
		}
	}
	
	public int selEmail(UserVO param) {
		UserVO dbUser = mapper.selUser(param);
		if(dbUser == null) {
			return Const.SUCCESS;
		}else {
			return Const.FAIL;
		}
	}
	
	public int delEmail(UserVO param) {
		return mapper.delEmail(param);
	}

}
