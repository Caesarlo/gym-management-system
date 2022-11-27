package com.gym.controller;

import com.github.pagehelper.PageInfo;
import com.gym.entity.Coach;
import com.gym.entity.Result;
import com.gym.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练控制层
 * @create: 2022-11-20 16:31
 **/
@Controller
@RequestMapping("/api")
@ResponseBody
public class CoachController {

    private CoachService coachServiceImpl;

    @Autowired
    public CoachController(CoachService coachServiceImpl) {
        this.coachServiceImpl = coachServiceImpl;
    }

    /**
     * 分页查询教练信息
     *
     * @param startPage 起始页码
     * @param pageSize  页码容量
     * @return 数据集合
     */
    @GetMapping("/coach/chaXunFenYe/{startPage}/{pageSize}")
    public Result<PageInfo<Coach>> getCoachByPage(@PathVariable("startPage") Integer startPage,
                                                  @PathVariable("pageSize") Integer pageSize) {
        return coachServiceImpl.getCoachByPage(startPage, pageSize);
    }

    /**
     * 模糊分页查询
     *
     * @param startPage 起始页码
     * @param pageSize  页码容量
     * @param keyword   关键字
     * @return 数据集合
     */
    @GetMapping("/coach/chaXunFenYe/{startPage}/{pageSize}/{keyword}")
    public Result<PageInfo<Coach>> getCoachByVague(@PathVariable("startPage") Integer startPage,
                                                   @PathVariable("pageSize") Integer pageSize,
                                                   @PathVariable("keyword") String keyword) {
        return coachServiceImpl.getCoachByVague(startPage, pageSize, keyword);
    }

    /**
     * 根据id查询教练信息
     *
     * @param id 教练id
     * @return 教练信息
     */
    @GetMapping("/coach/{id}")
    public Result<Coach> getCoachById(@PathVariable("id") String id) {
        return coachServiceImpl.getCoachById(id);
    }

    /**
     * 注册教练，教练认证
     *
     * @param coach 教练信息
     * @return
     */
    @GetMapping("/coach/xinZeng")
    public Result insertCoach(@RequestBody Coach coach) {
        return coachServiceImpl.insertCoach(coach);
    }

    /**
     * 更新教练信息
     * @param coach 教练信息
     * @return
     */
    @GetMapping("/coach/gengXinById")
    public Result updateCoach(@RequestBody Coach coach) {
        return coachServiceImpl.updateCoach(coach);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/coach/shanChuById")
    public Result deleteCoach(@PathVariable("id") String id){
        return coachServiceImpl.deleteCoach(id);
    }


}
