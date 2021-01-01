package com.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dao.entity.RoleEntity;

public interface RolesDaoRepository extends JpaRepository<RoleEntity, Integer>{

}
