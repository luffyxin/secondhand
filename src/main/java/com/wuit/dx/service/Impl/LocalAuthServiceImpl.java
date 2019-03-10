package com.wuit.dx.service.Impl;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.mapper.LocahAuthMapper;
import com.wuit.dx.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ${DX} on 2018/10/27.
 */
@Service
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocahAuthMapper locahAuthMapper;

    @Override
    public boolean isNameExists(String name) {
        LocahAuth locahAuth=locahAuthMapper.getAuthByName(name);
        if(locahAuth==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean registerAuth(LocahAuth localAuth) {
        localAuth.setCreateTime(new Date());
        localAuth.setLastEditTime(new Date());
        int i=locahAuthMapper.insertAuth(localAuth);
        if(i==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean loginAuth(LocahAuth locahAuth) {
        LocahAuth  right=locahAuthMapper.getAuthByName(locahAuth.getUsername());
        if(right==null){
            return false;
        }

        if(right.getPassword().equals(locahAuth.getPassword())){
            return true;
        }
        return false;
    }
}
