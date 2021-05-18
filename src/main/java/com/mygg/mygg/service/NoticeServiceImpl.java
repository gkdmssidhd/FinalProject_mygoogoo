package com.mygg.mygg.service;

import com.mygg.mygg.domain.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Map<String, Object>> getNotices(Integer board_page) {
        return noticeRepository.getNotices(board_page);
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
    public int deleteNotice(int board_id) {
        return noticeRepository.deleteNotice(board_id);
    }

    @Override
    public List<Map<String, Object>> searchNotices(Map<String,String> searchValue) {
        return noticeRepository.searchNotices(searchValue);
    }

    @Override
    public Double getTotal() {
        return noticeRepository.getTotal();
    }


}