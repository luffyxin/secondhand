package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.PersonInfoDAO;
import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.service.PersonInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dx
 * @since 2019/3/16 17:26
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Resource
    private PersonInfoDAO personInfoDAO;

    @Override
    public PersonInfo findbyLocalAuth(LocahAuth locahAuth) {
        return personInfoDAO.findByLocalAuth(locahAuth);
    }
}
