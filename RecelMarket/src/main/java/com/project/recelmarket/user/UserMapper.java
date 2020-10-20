package com.project.recelmarket.user;



import org.apache.ibatis.annotations.Mapper;

import com.project.recelmarket.user.vo.UserParam;
import com.project.recelmarket.user.vo.UserVO;

@Mapper
public interface UserMapper {
	void insUser(UserVO param);

	int upd_AuthKey(UserVO param);

	int ins_singUp(UserVO param);

	int upd_AuthStatus(UserVO param);

	UserVO selUser(UserVO param);

	UserParam selEmail(UserParam param);

	int delEmail(UserVO param);
}
