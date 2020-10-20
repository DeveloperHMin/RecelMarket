package com.project.recelmarket.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	List<CodeVO> selCodeList();
	List<CodeVO> selCodeDetailList(CodeVO param);
}
