package com.mygg.mygg.service.impl;

import com.mygg.mygg.domain.repository.AdminRepository;
import com.mygg.mygg.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Map<String, Object>> getAcceptLists(int page, int rv_state) {
        return  adminRepository.getAcceptLists(page,rv_state);
    }

    @Override
    public int finishReserve(int service_no) {
        return adminRepository.finishReserve(service_no);
    }
}
