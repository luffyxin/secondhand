package com.wuit.dx.service.Impl;

import com.wuit.dx.dao.PersonInfoDAO;
import com.wuit.dx.entity.LocahAuth;
import com.wuit.dx.entity.PersonInfo;
import com.wuit.dx.service.PersonInfoService;
import com.wuit.dx.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public PersonInfo savePersonInfo(PersonInfo personInfo) {
        return personInfoDAO.save(personInfo);
    }

    @Override
    public PersonInfo findById(int id) {
        return personInfoDAO.findById(id);
    }

    @Override
    public Page4Navigator<PersonInfo> findAll(int start, int size, int navigatePages) {
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(start,size,sort);
        Page page=personInfoDAO.findAll(pageable);
        Page4Navigator<PersonInfo> personinfo=new Page4Navigator<>(page,navigatePages);
        return personinfo;
    }
}
