package com.mygg.mygg.testcontroller;

import com.mygg.mygg.application.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice")
    public String getNotices(Model model){
        model.addAttribute("notices",noticeService.getNotices());
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

    @PostMapping("/notice/write")
    public String writeNotice(@RequestParam Map<String,String> writedValue){
        noticeService.insertNotice(writedValue);
        return "redirect:/notice";
    }

    @GetMapping("/notice/update/{board_id}")
    public String updateNotice(@PathVariable("board_id") int board_id, Model model){
        model.addAttribute("notice", noticeService.getNotice(board_id));
        return "/notice/notice_update";
    }

    @PostMapping("/notice/update")
    public String updateNotice(@RequestParam Map<String,String> updatedValue){
        System.out.println("여기는 포스트업데이트입니다입니다 "+updatedValue);
        noticeService.updateNotice(updatedValue);
        return "redirect:/notice";
    }
}
