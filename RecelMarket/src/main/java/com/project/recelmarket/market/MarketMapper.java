package com.project.recelmarket.market;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.recelmarket.market.vo.MarketParam;
import com.project.recelmarket.market.vo.MarketPicVO;
import com.project.recelmarket.market.vo.PagingVO;

@Mapper
public interface MarketMapper {

	//글쓰기 다중 insert
	int insWrite(MarketParam param);
	void insPic(MarketPicVO vo);
	
	//메인화면에 띄울 정보들
	int ctnt();
	List<MarketParam> maininfo(PagingVO param);
	//detail 화면에 띄울 정보들
	MarketParam maininfo(MarketParam vo);
	List<MarketPicVO> selPic(MarketParam param);
}
