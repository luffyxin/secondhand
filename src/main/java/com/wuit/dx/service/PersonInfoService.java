package com.wuit.dx.service;

import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.util.Page4Navigator;
import org.springframework.data.domain.Pageable;

/**
 * @author dx
 * @since 2019/3/16 17:25
 */
public interface PersonInfoService {
    PersonInfo findbyLocalAuth(LocahAuth locahAuth);

    PersonInfo savePersonInfo(PersonInfo personInfo);

    PersonInfo findById(int id);

    Page4Navigator<PersonInfo>  findAll(int start, int size, int navigatePages);
 }
