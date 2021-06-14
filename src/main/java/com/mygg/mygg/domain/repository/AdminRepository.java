package com.mygg.mygg.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminRepository {
    List<Map<String,Object>> getAcceptLists(@Param("page") int page,@Param("rv_state") int rv_state);
    int finishReserve(@Param("service_no") int service_no);
}
