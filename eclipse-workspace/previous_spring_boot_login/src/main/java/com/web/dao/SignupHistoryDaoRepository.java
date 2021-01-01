package com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dao.entity.SignupHistoryEntity;

public interface SignupHistoryDaoRepository extends JpaRepository<SignupHistoryEntity, Integer>{

}
