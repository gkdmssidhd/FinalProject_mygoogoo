package com.mygg.mygg.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.dto.MemberDTO;

import java.util.Map;

@Mapper
public interface MemberDAO {

    void register(MemberDTO memberDTO) ;
    Map<String,String> login(LoginDTO loginDTO) ;
}