package com.wuit.dx.dao;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/11 17:23
 */
public interface PersonInfoDAO extends JpaRepository<PersonInfo,Integer> {

     PersonInfo findById(int id);

    PersonInfo findByLocalAuth(LocahAuth locahAuth);

}
