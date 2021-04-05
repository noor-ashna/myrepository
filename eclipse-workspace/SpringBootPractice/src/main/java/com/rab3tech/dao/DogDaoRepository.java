package com.rab3tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.DogEntity;

public interface DogDaoRepository extends JpaRepository<DogEntity,Integer>{

}
