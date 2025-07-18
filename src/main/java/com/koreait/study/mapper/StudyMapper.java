package com.koreait.study.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.koreait.study.model.Study;

@Mapper
public interface StudyMapper {
    List<Study> findAll(@Param("search") String search,
                        @Param("offset") int offset,
                        @Param("size") int size);
    Study findById(int id);
    void insert(Study study);
}
