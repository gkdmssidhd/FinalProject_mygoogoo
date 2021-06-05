package com.mygg.mygg.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ChatRepository {
    List<Map<String,Object>> getChats(String nickName);
    List<Map<String,Object>> getChat(int room_id);
    int insertChat(HashMap<String, Object> form_value);
}
