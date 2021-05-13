package com.mygg.mygg.application;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    List<Map<String,Object>> getNotices();
    Map<String,Object> getNotice(int board_id);
    int insertNotice();
    int updateNotice();
    int deleteNotice();
    List<Map<String,Object>> searchNotices();

}
