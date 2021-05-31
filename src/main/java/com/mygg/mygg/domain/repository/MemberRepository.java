package com.mygg.mygg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygg.mygg.domain.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String userEmail);
}