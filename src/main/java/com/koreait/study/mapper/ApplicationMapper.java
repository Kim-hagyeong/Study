package com.koreait.study.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.koreait.study.model.Study;

@Mapper
public interface ApplicationMapper {
    int exists(@Param("userId") String userId, @Param("studyId") int studyId);
    void insert(@Param("userId") String userId, @Param("studyId") int studyId);
    List<Study> findByUserId(String userId);
}
