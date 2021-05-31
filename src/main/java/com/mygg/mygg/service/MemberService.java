package com.mygg.mygg.service;

import org.springframework.stereotype.Service;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.dto.MemberDTO;
import com.mygg.mygg.vo.MemberVO;

import java.util.Map;

public interface MemberService {

    public void register(MemberDTO memberDTO);

    Map<String, String> login(LoginDTO loginDTO) throws Exception;
}