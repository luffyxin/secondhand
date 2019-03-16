package com.wuit.dx.service;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.PersonInfo;

/**
 * @author dx
 * @since 2019/3/16 17:25
 */
public interface PersonInfoService {
    PersonInfo findbyLocalAuth(LocahAuth locahAuth);
}
