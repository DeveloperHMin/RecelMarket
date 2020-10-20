package com.project.recelmarket.market;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.recelmarket.Const;
import com.project.recelmarket.common.CodeVO;
import com.project.recelmarket.common.CommonMapper;
import com.project.recelmarket.common.FileUtils;
import com.project.recelmarket.market.vo.MarketParam;
import com.project.recelmarket.market.vo.MarketPicVO;
import com.project.recelmarket.market.vo.PagingVO;

@Service
public class MarketService {

	@Autowired
	private MarketMapper mapper;

	@Autowired
	private CommonMapper cMapper;

	public List<CodeVO> codeList() {
		return cMapper.selCodeList();
	}

	public List<CodeVO> detailCodeList(CodeVO param) {
		return cMapper.selCodeDetailList(param);
	}

	public int insWrite(MarketParam param) {
		return mapper.insWrite(param);
	}

	public void insPic(MarketParam param, MultipartHttpServletRequest mReq) {
		int i_recel = param.getI_recel();

		List<MultipartFile> fileList = mReq.getFiles("file");
		System.out.println("fileList : " + fileList.size());
		String path = Const.realPath + "/resources/img/recel/" + i_recel + "/recel_img/";

		List<MarketPicVO> list = new ArrayList();

		for (int i = 0; i < fileList.size(); i++) {
			MarketPicVO vo = new MarketPicVO();
			list.add(vo);
			vo.setI_recel(i_recel);

			MultipartFile mf = fileList.get(i);

			String saveFileNm = FileUtils.saveFile(path, mf);
			System.out.println("saveFileNm: " + saveFileNm);
			vo.setRecel_pic(saveFileNm);
		}
		for (MarketPicVO vo : list) {
			mapper.insPic(vo);
		}
	}

	public MarketParam maininfo(PagingVO page) {
		int ctnt = mapper.ctnt();
		int record_cnt = 12;
		int pagingEnd = ctnt % record_cnt;
		int setPage = 0;
		if (ctnt < record_cnt) {
			setPage = 1;
		} else if (pagingEnd != 0) {
			setPage = (ctnt / record_cnt) + 1;
		} else {
			setPage = ctnt / record_cnt;
		}
		System.out.println("setPage: " + setPage);
		System.out.println("paingEnd: " + pagingEnd);
		int pagingStart = 0;
		int pagingNum = page.getPage();

		if (pagingNum <= 0) {
			pagingNum = 1;
		} else if (pagingNum >= setPage) {
			pagingNum = setPage;
		}

		if (pagingNum == 1) {
			pagingStart = 0;
		} else if (pagingNum == (ctnt / record_cnt) + 1) {
			pagingStart = (pagingNum * (ctnt / record_cnt))+pagingEnd;
			System.out.println("3번");
		} else if (pagingEnd != 0 || ctnt <= record_cnt) {
			pagingStart = pagingNum * (ctnt / record_cnt);
			System.out.println("1번: ");
		} else {
			pagingStart = pagingNum * (ctnt / record_cnt);
			System.out.println("2번 :");
		}
		System.out.println("pagingStart: " + pagingStart);
		page.setPagingStart(pagingStart*4);
		page.setRecord_cnt(record_cnt);
		List<MarketParam> param = mapper.maininfo(page);
		MarketParam list = new MarketParam();
		list.setList(param);
		list.setPage(setPage);
		return list;
	}

	public MarketParam detailinfo(MarketParam param) {
		return mapper.maininfo(param);
	}

	public List<MarketPicVO> selPic(MarketParam param) {
		return mapper.selPic(param);
	}
}
