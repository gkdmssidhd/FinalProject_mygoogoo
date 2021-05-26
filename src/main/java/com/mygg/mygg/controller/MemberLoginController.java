package com.mygg.mygg.controller;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.service.MemberService;
import com.mygg.mygg.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberLoginController {

    private final MemberService memberService;


    @Autowired
    public MemberLoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    // login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(@ModelAttribute("loginDTO")LoginDTO loginDTO) {
        return "/member/login";
    }


    @PostMapping("/user/login")
    public String checkLogin(LoginDTO dto, HttpServletRequest request) throws Exception {


        Map<String, String> member = memberService.login(dto);
        System.out.println(member);
        System.out.println(member.get("email")+"   맵에있는 이메일입니다");
        System.out.println(member.get("password")+"   맵에있는 패스워드입니다");
        System.out.println(dto.getEmail()+" dto에 있는 이메일입니다");
        System.out.println(dto.getPassword()+" dto에 있는 패스워드니다");


        if(member.get("email").equals(dto.getEmail()) && member.get("password").equals(dto.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("member_id",member.get("id"));
            System.out.println("세션부여됨");
            return "/member/loginSuccess";
        }else{
            System.out.println("맞지않음");
            return "redirect:/member/login";
        }
    }



}

