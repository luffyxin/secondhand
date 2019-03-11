package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.LocahAuthDAO;
import com.wuit.dx.entity.LocahAuth;
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
        localAuth.setCreateTime(new Date());
        localAuth.setLastEditTime(new Date());
        LocahAuth save = locahAuthDAO.save(localAuth);
        return save != null;
    }

    @Override
    public boolean loginAuth(LocahAuth locahAuth) {
        LocahAuth right = locahAuthDAO.findByUsername(locahAuth.getUsername());
        if (right == null) {
            return false;
        }

        if (right.getPassword().equals(locahAuth.getPassword())) {
            return true;
        }
        return false;
    }
}
