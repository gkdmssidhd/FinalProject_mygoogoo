package com.mygg.mygg.testcontroller;

import com.mygg.mygg.application.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice")
    public String getNotices(Model model){
        model.addAttribute("notices",noticeService.getNotices());
        System.out.println("여기는 노티스입니다 그리고 값은 "+model.getAttribute("notices"));
        return "/notice/notice";
    }

    @GetMapping("/notice/detail/{board_id}")
    public String getDetail(@PathVariable("board_id") int board_id, Model model){

        model.addAttribute("notice", noticeService.getNotice(board_id));
        return "/notice/notice_detail";
    }

    @GetMapping("/notice/write")
    public String write(){
        return "/notice/write";
    }
}
