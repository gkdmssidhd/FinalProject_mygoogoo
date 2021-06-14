package com.mygg.mygg.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Map<String,Object>> getAcceptLists(int page, int rv_state);
    int finishReserve(@Param("service_no") int service_no);

}
