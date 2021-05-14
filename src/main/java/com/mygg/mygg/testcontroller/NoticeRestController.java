package com.mygg.mygg.testcontroller;

import com.mygg.mygg.application.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NoticeRestController {

    @Autowired
    NoticeService noticeService;


    @PostMapping("notice/delete/{board_id}")
    public int deleteNotice(@PathVariable("board_id") int board_id){

        return noticeService.deleteNotice(board_id);
    }

    @PostMapping("/notice/search")
    public List<Map<String,Object>> searchNotices(@RequestParam Map<String,String> searchValue,Model model){
        System.out.println(searchValue);
        System.out.println(noticeService.searchNotices(searchValue));
        return noticeService.searchNotices(searchValue);
    }
}
