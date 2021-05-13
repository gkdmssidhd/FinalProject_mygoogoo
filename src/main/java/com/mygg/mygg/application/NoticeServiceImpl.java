package com.mygg.mygg.application;

import com.mygg.mygg.domain.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Map<String, Object>> getNotices() {
        return noticeRepository.getNotices();
    }

    @Override
    public Map<String, Object> getNotice(int board_id) {
        return noticeRepository.getNotice(board_id);
    }

    @Override
    public int insertNotice(Map<String, String> writedValue) {
        return noticeRepository.insertNotice(writedValue);
    }

    @Override
    public int updateNotice(Map<String, String> updatedValue) {
        return noticeRepository.updateNotice(updatedValue);
    }


    @Override
    public int deleteNotice() {
        return 0;
    }

    @Override
    public List<Map<String, Object>> searchNotices() {
        return null;
    }
}
