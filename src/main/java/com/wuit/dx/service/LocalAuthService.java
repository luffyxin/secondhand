package com.wuit.dx.service;

import com.wuit.dx.entity.LocahAuth;

/**
 * Created by ${DX} on 2018/10/27.
 */
public interface LocalAuthService {

    boolean isNameExists(String name);

    boolean registerAuth(LocahAuth localAuth);

    LocahAuth loginAuth(LocahAuth locahAuth);

    LocahAuth updatePassWd(LocahAuth locahAuth);
}
