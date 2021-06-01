package com.mygg.mygg.controller;

import com.mygg.mygg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MyPageController {

    @Autowired
    private MemberService memberService;



    @GetMapping("/info")
    public String myPage(HttpSession httpSession) throws Exception {
        Integer id = (int)httpSession.getAttribute("id");
        Map<String, String> memberActivity = memberService.activity(id);

        System.out.println(memberActivity+"멤버액티비티내용ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
        
        if(memberActivity.get("id") != null) {
            httpSession.setAttribute("level", memberActivity.get("level"));
            httpSession.setAttribute("wish", memberActivity.get("wish"));
            httpSession.setAttribute("batch", memberActivity.get("batch"));
            httpSession.setAttribute("mileage", memberActivity.get("mileage"));
            return "/member/myinfo";
        } else {
            return "redirect:/member/login";
        }
    }

}