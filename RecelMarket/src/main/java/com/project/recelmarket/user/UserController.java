package com.project.recelmarket.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.recelmarket.Const;
import com.project.recelmarket.ViewRef;
import com.project.recelmarket.user.email.MailSendService;
import com.project.recelmarket.user.vo.UserParam;
import com.project.recelmarket.user.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
    @Autowired
    private MailSendService mss;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(Const.CSS, "login");
		model.addAttribute(Const.TITLE, "로그인");
		model.addAttribute(Const.VIEW, "user/login");
		return ViewRef.TEMP_DEFAULT;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST) 
	public String login(UserVO param, HttpSession hs, RedirectAttributes ra) {
		int result = service.login(param);
		
		if(result == Const.SUCCESS) {
			hs.setAttribute(Const.LOGIN_USER, param);
			return "redirect:/recel/market";
		}
		
		String msg = null;
		if(result == Const.NO_ID) {
			msg = "아이디를 확인해 주세요.";
		} else if(result == Const.NO_PW) {
			msg = "비밀번호를 확인해 주세요.";
		}
		
		UserParam vo = new UserParam();
		
		vo.setMsg(msg);
		ra.addFlashAttribute("data", vo);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "redirect:/recel/market";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join(Model model, UserVO param) {
		model.addAttribute(Const.CSS, "join");
		model.addAttribute(Const.TITLE, "회원가입");
		model.addAttribute(Const.VIEW, "user/join");
		return ViewRef.TEMP_DEFAULT;
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinProc(Model model, UserVO param) {
		service.joinProc(param);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/ajaxIdChk", method=RequestMethod.POST)
	@ResponseBody
	public String ajaxIdChk(@RequestBody UserVO param) {
		System.out.println("user_id : " + param.getUser_id());
		int result = service.login(param);
		return String.valueOf(result);
	}
	
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public int signUp(@RequestBody UserVO param){
    	
    	int selEmail = service.selEmail(param);
    	
    	if(selEmail == Const.FAIL) {return Const.FAIL;}
       // DB에 기본정보 insert
    	service.signUp(param);

       //임의의 authKey 생성 & 이메일 발송
       String authKey = mss.sendAuthMail(param.getEmail());
       param.setAuthKey(authKey);

      
       //DB에 authKey 업데이트
       return service.updateAuthKey(param);

 	}
    
    @RequestMapping(value = "/chk_auth", method = RequestMethod.POST)
    @ResponseBody
    public int chk_auth(@RequestBody UserParam param){
    	
    	int selEmail = service.selAuth(param);
    	if(selEmail != 1) {
    		return Const.FAIL;
    	}else {
    		return Const.SUCCESS;
    	}

 	}
    
    @RequestMapping(value = "/delEmail", method = RequestMethod.POST)
    @ResponseBody
    public int delEmail(@RequestBody UserParam param){
    	return service.delEmail(param);
 	}
    
    
    @RequestMapping(value= "/signUpConfirm", method= RequestMethod.POST)
    public String signUpConfirm(UserVO param, Model model){
       //email, authKey 가 일치할경우 authStatus 업데이트
       service.updateAuthStatus(param);
       return ViewRef.USER_CONFIRM;
   }

}
