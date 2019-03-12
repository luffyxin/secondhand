package com.wuit.dx.dao;

import com.wuit.dx.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dx
 * @since 2019/3/11 17:23
 */
public interface PersonInfoDAO extends JpaRepository<PersonInfo,Integer> {

     PersonInfo findById(Long id);

}
