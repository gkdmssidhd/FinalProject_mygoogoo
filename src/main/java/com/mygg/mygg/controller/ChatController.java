package com.mygg.mygg.controller;

import com.mygg.mygg.dto.RoomDto;
import com.mygg.mygg.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class ChatController {

    @Autowired
    ChatService chatService;

    List<RoomDto> roomList = new ArrayList<RoomDto>();

    static int roomNumber = 0;

//    @GetMapping("/chat")
//    public String chat(HttpServletRequest request,Model model) {
//        HttpSession session = request.getSession();
//        return "/chat/chat";
//    }

    /**
     * 방 페이지
     *
     * @return
     */
    @GetMapping("/room")
    public String room(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("nickname") != null) {
            List<Map<String,Object>> list = chatService.getChats(session.getAttribute("nickname").toString());
            model.addAttribute("lists", list);
            return "/chat/chatRoom";
        }else{
            return "redirect:/";
        }

    }

    /**
     * 방 생성하기
     * @param params
     * @return
     */
    @RequestMapping("/createRoom")
    public @ResponseBody List<RoomDto> createRoom(@RequestParam HashMap<Object, Object> params){

        String roomName = (String) params.get("roomName");
        int roomNo = Integer.parseInt((String)params.get("roomNumber"));

        if(roomName != null && !roomName.trim().equals("")) {
            if(roomList==null){
                RoomDto room = new RoomDto();
                room.setRoomNumber(roomNo);
                room.setRoomname(roomName);
                roomList.add(room);
            }else {
                for(int i = 0; i <roomList.size() ; i++){
                    if(roomList.get(i).getRoomNumber()==roomNo){
                        return roomList;
                    }
                }
                RoomDto room = new RoomDto();
                room.setRoomNumber(roomNo);
                room.setRoomname(roomName);
                roomList.add(room);
            }
        }

        return roomList;
    }

    /**
     * 방 정보가져오기
     * @param params
     * @return
     */
    @RequestMapping("/getRoom")
    public @ResponseBody List<RoomDto> getRoom(@RequestParam HashMap<Object, Object> params){
        return roomList;
    }

    /**
     * 채팅방
     * @return
     */
    @RequestMapping("/moveChating")
    public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {

        ModelAndView mv = new ModelAndView();
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

        List<RoomDto> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
        if(new_list != null && new_list.size() > 0) {
            System.out.println(params.get("roomName")+"룸네임ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
            mv.addObject("roomName", params.get("roomName"));
            mv.addObject("roomNumber", params.get("roomNumber"));
            mv.addObject("lists", chatService.getChat(Integer.parseInt((String)params.get("roomNumber"))));
            mv.setViewName("/chat/chat");
        }else {
            mv.setViewName("/chat/chatRoom");
        }
        return mv;
    }

    @PostMapping("/insertChat")
    @ResponseBody
    public int insertChat(@RequestBody HashMap<String,Object> form_value){

        System.out.println(form_value+"폼벨류입니다@@@@@@@@@@@@@@@@@@@@@@@");

        int room_id=Integer.parseInt((String) form_value.get("room_id"));
        String chat_writer=(String) form_value.get("chat_writer");
        String chat_content=(String) form_value.get("chat_content");

        System.out.printf("룸아이디 : %d 글쓴이 : %s 내용 : %s",room_id,chat_writer,chat_content);

        return chatService.insertChat(form_value);

    }
}
