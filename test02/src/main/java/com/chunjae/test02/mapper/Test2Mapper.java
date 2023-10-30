package com.chunjae.test02.mapper;

import com.chunjae.test02.domain.Test2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Test2Mapper {
    @Select("select * from test2")
    public List<Test2> getList();

    List<Test2> getList2();
}
