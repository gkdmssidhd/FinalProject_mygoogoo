package com.mygg.mygg.service;

import java.util.List;
import java.util.Map;

public interface ChatService {
    List<Map<String,Object>> getChats(String nickName);
}
