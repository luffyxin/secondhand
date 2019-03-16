package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.LocahAuthDAO;
import com.wuit.dx.dao.PersonInfoDAO;
import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.service.LocalAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ${DX} on 2018/10/27.
 */
@Service
public class LocalAuthServiceImpl implements LocalAuthService {

    @Resource
    private LocahAuthDAO locahAuthDAO;

    @Resource
    private PersonInfoDAO personInfoDAO;

    @Override
    public boolean isNameExists(String name) {
        LocahAuth locahAuth = locahAuthDAO.findByUsername(name);
        if (locahAuth == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean registerAuth(LocahAuth localAuth) {
        LocahAuth save = locahAuthDAO.save(localAuth);
        PersonInfo p=new PersonInfo();
        p.setLocalAuth(save);
        PersonInfo psave= personInfoDAO.save(p);
        return save != null;
    }

    @Override
    public LocahAuth loginAuth(LocahAuth locahAuth) {
        LocahAuth auth=  locahAuthDAO.findByUsernameAndPassword(locahAuth.getUsername(),locahAuth.getPassword());
        return auth;
    }
}
