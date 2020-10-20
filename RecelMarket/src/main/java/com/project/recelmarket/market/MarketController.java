package com.project.recelmarket.market;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.recelmarket.Const;
import com.project.recelmarket.SecurityUtils;
import com.project.recelmarket.ViewRef;
import com.project.recelmarket.common.CodeVO;
import com.project.recelmarket.market.vo.MarketParam;
import com.project.recelmarket.market.vo.PagingVO;

@Controller
@RequestMapping("/recel")
public class MarketController {
	
	@Autowired
	private MarketService service;
	
	@RequestMapping("/market")
	public String market(Model model, PagingVO param) {
		model.addAttribute("data", service.maininfo(param));
		model.addAttribute(Const.TITLE, "중고장터");
		model.addAttribute(Const.VIEW, "recel/marketmain");
		return ViewRef.TEMP_RECEL_TEMP;
	}
	
	@RequestMapping("/write")
	public String write(Model model) {
		model.addAttribute("cdList", service.codeList());
		model.addAttribute(Const.TITLE, "글쓰기");
		model.addAttribute(Const.VIEW, "recel/marketwrite");
		model.addAttribute(Const.CSS, "write");
		return ViewRef.TEMP_RECEL_TEMP;
	}
	
	@RequestMapping(value = "/write", method= RequestMethod.POST)
	public String insWrite(Model model, MarketParam param, HttpSession hs,MultipartHttpServletRequest mReq) {
		int i_user = SecurityUtils.getLoginUserPk(hs);
		param.setI_user(i_user);
		int i_recel = service.insWrite(param);
		param.setI_recel(i_recel);
		service.insPic(param, mReq);
		return "redirect:/recel/market";
	}
	
	@RequestMapping(value="/ajaxDetailCodeList", method = RequestMethod.GET)
	@ResponseBody
	public List<CodeVO> ajaxDetailCodeList(CodeVO param) {
		
		System.out.println(param.getI_m());
		return service.detailCodeList(param);
	}
	
	@RequestMapping(value="/detailMarket",  method = RequestMethod.GET)
	public String detailinfo(Model model, MarketParam param) {
		model.addAttribute("data", service.detailinfo(param));
		model.addAttribute("pic", service.selPic(param));
		model.addAttribute(Const.TITLE, "상세보기");
		model.addAttribute(Const.VIEW, "recel/marketdetail");
		model.addAttribute(Const.CSS, "detail");
		return ViewRef.TEMP_RECEL_TEMP;
	} 
}
