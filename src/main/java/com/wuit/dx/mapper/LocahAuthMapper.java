package com.wuit.dx.mapper;

import com.wuit.dx.entity.LocahAuth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by ${DX} on 2018/10/27.
 */
@Component
public interface LocahAuthMapper {
    @Select("select username,password from locah_auth where username=#{name}")
    LocahAuth getAuthByName(String name);

    @Insert("insert into locah_auth (username,password,create_time,last_edit_time)" +
            " values (#{username},#{password},#{createTime},#{lastEditTime})")
    int insertAuth(LocahAuth locahAuth);

}
