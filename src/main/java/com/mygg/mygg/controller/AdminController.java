package com.mygg.mygg.controller;

import com.mygg.mygg.service.AdminService;
import com.mygg.mygg.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    ChatService chatService;

    @GetMapping(value={"/admin/accept/{rv_state}/{page}","/admin"})
    public String getAcceptMenu(@PathVariable(required = false) Integer rv_state, @PathVariable(required = false) Integer page, Model model){

        if(page != null &&rv_state != null){
            List<Map<String, Object>> lists = adminService.getAcceptLists((page - 1) * 10 * 2, rv_state);
            int totalPage = (int)Math.ceil(lists.size()/20);
            model.addAttribute("lists", lists);
            model.addAttribute("totalPage", totalPage);

            System.out.println("이프에걸림");
            System.out.println(lists);
            
        }else{
            List<Map<String, Object>> lists = adminService.getAcceptLists(0, 3);
            int totalPage = (int)Math.ceil(lists.size()/20);

            model.addAttribute("lists",lists);
            model.addAttribute("totalPage", totalPage);

            System.out.println("엘스에걸림");
            System.out.println(lists);
        }


        return "/admin/accept";
    }
    
    @PostMapping("/admin/accept")
    @ResponseBody
    public int acceptOrder(@RequestBody HashMap<String,Integer> acceptValue){
        System.out.println(acceptValue);

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("room_status", 4);
        map.put("room_id", acceptValue.get("room_id"));
        chatService.accept(map);
        adminService.finishReserve(acceptValue.get("service_no"));
        return 1;
    } 
}
