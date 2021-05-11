package com.mygg.mygg.testcontroller;

import com.mygg.mygg.application.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/test")
    public String button(Model model, HttpServletRequest request){
        model.addAttribute("lists",chatService.getChats());
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("userId")+"새로고침했을때 이 브라우저의 세션");
//        session.setAttribute("userId","UserA");
        return "order";
    }

    @GetMapping("test/result")
    public String result(){

        return "result";
    }

    @GetMapping("/")
    public String login(){

        return "login";
    }




}
