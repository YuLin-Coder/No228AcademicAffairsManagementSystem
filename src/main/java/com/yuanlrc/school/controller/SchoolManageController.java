package com.yuanlrc.school.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanlrc.school.entity.*;
import com.yuanlrc.school.service.SchoolManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("schoolmanage")
public class SchoolManageController extends BaseController {
    @Autowired
    private SchoolManageService schoolManageService;

    /**
     * 进入班级管理页面
     */
    @RequestMapping("classmanage")
    public String classmanage() {
        return "view/schoolmanage/classmanage";
    }

    /**
     * 进入年级管理页面
     */
    @RequestMapping("grademanage")
    public String grademanage() {
        return "view/schoolmanage/grademanage";
    }

    /**
     * 进入专业管理页面
     */
    @RequestMapping("majormanage")
    public String majormanage() {
        return "view/schoolmanage/majormanage";
    }

    /**
     * 进入系部管理页面
     */
    @RequestMapping("dpmmanage")
    public String dpmmanage() {
        return "view/schoolmanage/dpmmanage";
    }

    /*******************************************************************系部管理*********************************************************************/

    /**
     * 添加系部
     */
    @RequestMapping("addonedpm")
    @ResponseBody
    public Object addOneDpm(DepartmentDB departmentDB) {
        int check = schoolManageService.checkOneDpm(departmentDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.addOneDpm(departmentDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * 获取系部列表
     */
    @RequestMapping("findalldpm")
    @ResponseBody
    public Object findAllDpm(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.findAllDpm(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> dpmData = new HashMap<String, Object>();
        dpmData.put("code", 0);
        dpmData.put("msg", "");
        dpmData.put("count", pageInfo.getTotal());
        dpmData.put("data", pageInfo.getList());
        return dpmData;
    }


    /**
     * 编辑系部
     */
    @RequestMapping("editonedpm")
    @ResponseBody
    public Object editOneDpm(DepartmentDB departmentDB) {
        int check = schoolManageService.checkOneDpm(departmentDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.editOneDpm(departmentDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*******************************************************************专业管理*********************************************************************/

    /**
     * 添加专业
     */
    @RequestMapping("addonemajor")
    @ResponseBody
    public Object addOneMajor(MajorDB majorDB) {
        int check = schoolManageService.checkOneMajor(majorDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.addOneMajor(majorDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 获取专业列表
     */
    @RequestMapping("findallmajor")
    @ResponseBody
    public Object findAllMajor(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.findAllMajor(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> majorData = new HashMap<String, Object>();
        majorData.put("code", 0);
        majorData.put("msg", "");
        majorData.put("count", pageInfo.getTotal());
        majorData.put("data", pageInfo.getList());
        return majorData;
    }


    /**
     * 编辑专业
     */
    @RequestMapping("editonemajor")
    @ResponseBody
    public Object editOneMajor(MajorDB majorDB) {
        int check = schoolManageService.checkOneMajor(majorDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.editOneMajor(majorDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*******************************************************************年级管理*********************************************************************/

    /**
     * 添加年级
     */
    @RequestMapping("addonegrade")
    @ResponseBody
    public Object addOneGrade(GradeDB gradeDB) {
        int check = schoolManageService.checkOneGrade(gradeDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.addOneGrade(gradeDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 获取年级列表
     */
    @RequestMapping("findallgrade")
    @ResponseBody
    public Object findAllGrade(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.findAllGrade(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> gradeData = new HashMap<String, Object>();
        gradeData.put("code", 0);
        gradeData.put("msg", "");
        gradeData.put("count", pageInfo.getTotal());
        gradeData.put("data", pageInfo.getList());
        return gradeData;
    }

    /**
     * 级联获取专业列表
     */
    @RequestMapping("jlselmajor")
    @ResponseBody
    public Object jlSelMajor(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.jlSelMajor(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> jlmajorData = new HashMap<String, Object>();
        jlmajorData.put("code", 0);
        jlmajorData.put("msg", "");
        jlmajorData.put("count", pageInfo.getTotal());
        jlmajorData.put("data", pageInfo.getList());
        return jlmajorData;
    }


    /**
     * 编辑年级
     */
    @RequestMapping("editonegrade")
    @ResponseBody
    public Object editOneGrade(GradeDB gradeDB) {
        int check = schoolManageService.checkOneGrade(gradeDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.editOneGrade(gradeDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }


/*******************************************************************年级管理*********************************************************************/

    /**
     * 添加班级
     */
    @RequestMapping("addoneclass")
    @ResponseBody
    public Object addOneClass(ClassinfoDB classinfoDB) {
        int check = schoolManageService.checkOneClass(classinfoDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.addOneClass(classinfoDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 获取班级列表
     */
    @RequestMapping("findallclass")
    @ResponseBody
    public Object findAllClass(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.findAllClass(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> classData = new HashMap<String, Object>();
        classData.put("code", 0);
        classData.put("msg", "");
        classData.put("count", pageInfo.getTotal());
        classData.put("data", pageInfo.getList());
        return classData;
    }

    /**
     * 级联获取年级列表
     */
    @RequestMapping("jlselgrade")
    @ResponseBody
    public Object jlSelGrade(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.jlSelGrade(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> jlgradeData = new HashMap<String, Object>();
        jlgradeData.put("code", 0);
        jlgradeData.put("msg", "");
        jlgradeData.put("count", pageInfo.getTotal());
        jlgradeData.put("data", pageInfo.getList());
        return jlgradeData;
    }



    /**
     * 编辑班级
     */
    @RequestMapping("editoneclass")
    @ResponseBody
    public Object editOneClass(ClassinfoDB classinfoDB) {
        int check = schoolManageService.checkOneClass(classinfoDB);
        if (check > 0) {
            return false;
        } else {
            int r = schoolManageService.editOneClass(classinfoDB);
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

/*******************************************************************条件查询*********************************************************************/

    /**
     * 条件查询班级
     */
    @RequestMapping("tjselclass")
    @ResponseBody
    public Object tjSelClass(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.tjSelClass(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> classData = new HashMap<String, Object>();
        classData.put("code", 0);
        classData.put("msg", "");
        classData.put("count", pageInfo.getTotal());
        classData.put("data", pageInfo.getList());
        return classData;
    }

    /**
     * 条件查询系部
     */
    @RequestMapping("tjseldpm")
    @ResponseBody
    public Object tjSelDpm(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.tjSelDpm(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> dpmData = new HashMap<String, Object>();
        dpmData.put("code", 0);
        dpmData.put("msg", "");
        dpmData.put("count", pageInfo.getTotal());
        dpmData.put("data", pageInfo.getList());
        return dpmData;
    }

    /**
     * 条件查询专业
     */
    @RequestMapping("tjselmajor")
    @ResponseBody
    public Object tjSelMajor(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.tjSelMajor(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> majorData = new HashMap<String, Object>();
        majorData.put("code", 0);
        majorData.put("msg", "");
        majorData.put("count", pageInfo.getTotal());
        majorData.put("data", pageInfo.getList());
        return majorData;
    }

    /**
     * 条件查询年级
     */
    @RequestMapping("tjselgrade")
    @ResponseBody
    public Object tjSelGrade(SchoolManageVO schoolManageVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SchoolManageVO> listAll = schoolManageService.tjSelGrade(schoolManageVO);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> gradeData = new HashMap<String, Object>();
        gradeData.put("code", 0);
        gradeData.put("msg", "");
        gradeData.put("count", pageInfo.getTotal());
        gradeData.put("data", pageInfo.getList());
        return gradeData;
    }


}
