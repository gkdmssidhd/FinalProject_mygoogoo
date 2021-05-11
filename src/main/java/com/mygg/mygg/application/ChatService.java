package com.mygg.mygg.application;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChatService {
    List<Map<String,Object>> getChats();

    void updateStatus(Map<String, String> json);
}
