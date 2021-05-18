package com.mygg.mygg.service;

import com.mygg.mygg.domain.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Map<String, Object>> getChats() {
        System.out.println("서비스에서터짐");
        System.out.println(chatRepository.getChats()+"서비스내용");
        return chatRepository.getChats();
    }

    @Override
    public void updateStatus(Map<String, String> json) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@여기는 ServiceImpl"+json.get("status"));
        chatRepository.updateStatus(json);
    }

}
