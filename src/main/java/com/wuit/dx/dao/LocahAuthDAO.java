package com.wuit.dx.dao;

import com.wuit.dx.entity.LocahAuth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dx
 * @since 2019/3/11 17:22
 */
public interface LocahAuthDAO extends JpaRepository<LocahAuth,Integer> {
    LocahAuth findByUsername(String userName);
}
