package com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dao.entity.ProfileEntity;

public interface ProfileDaoRepository extends JpaRepository<ProfileEntity, Integer>{

}
