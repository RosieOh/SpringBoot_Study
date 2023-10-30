package com.chunjae.test03.mapper;

import com.chunjae.test03.domain.Test3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Test3Mapper {
    @Select("select * from test3")
    public List<Test3> getList();

    List<Test3> getList2();
}
