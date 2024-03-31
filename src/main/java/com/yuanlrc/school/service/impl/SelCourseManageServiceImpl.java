package com.yuanlrc.school.service.impl;

import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.mapper.SelCourseManageMapper;
import com.yuanlrc.school.service.SelCourseManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelCourseManageServiceImpl implements SelCourseManageService {
    @Resource
    private SelCourseManageMapper selCourseManageMapper;
    @Override
    public List<DepartmentDB> selDe() {
        return selCourseManageMapper.selDe();
    }

    @Override
    public List<MajorDB> selMa(Integer did) {
        return selCourseManageMapper.selMa(did);
    }

    @Override
    public List<GradeDB> selGr(Integer mid) {
        return selCourseManageMapper.selGr(mid);
    }

    @Override
    public List<ClassinfoDB> selClass(Integer gid) {
        return selCourseManageMapper.selClass(gid);
    }

    @Override
    public List<StudentDB> selSt(Integer classid) {
        return selCourseManageMapper.selSt(classid);
    }

    @Override
    public List<StuCourseVO> selSc(StuCourseVO stuCourseVO) {
        return selCourseManageMapper.selSc(stuCourseVO);
    }

    @Override
    public int dropcou(Integer sid, Integer cid) {
        return selCourseManageMapper.dropcou(sid,cid);
    }

    @Override
    public int updatecou(Integer cid) {
        return selCourseManageMapper.updatecou(cid);
    }

    @Override
    public int changesCou(@Param("ccd") Integer ccd, @Param("sid") Integer sid, @Param("cid") Integer cid) {
        return selCourseManageMapper.changesCou(ccd,sid,cid);
    }


    @Override
    public List<CourseDB> selCo() {
        return selCourseManageMapper.selCo();
    }

    @Override
    public int selStc(Integer ccd, Integer sid) {
        return selCourseManageMapper.selStc(ccd,sid);
    }
}
