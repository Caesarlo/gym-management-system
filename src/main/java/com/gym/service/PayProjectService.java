package com.gym.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.PayProjectMapper;
import com.gym.entity.PayProject;
import com.gym.entity.Result;
import com.gym.exception.PageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 项目服务层
 * @create: 2022-11-26 11:27
 **/
@Service
public class PayProjectService {

    @Autowired
    PayProjectMapper payProjectMapper;

    @Transactional
    public Result<PageInfo<PayProject>> showPayProject(int offset, int limit) {
        if (offset < 1) {
            throw new PageNumberException("起始页码无效！");
        }
        Result<PageInfo<PayProject>> result = new Result<>();
        PageHelper.startPage(offset, limit);
        List<PayProject> payProjectList = payProjectMapper.selectAllPayProject();
        PageInfo<PayProject> pageInfo = new PageInfo<>(payProjectList);
        result.setCode(Result.OK);
        result.setMsg("项目列表查询成功");
        result.setData(pageInfo);
        return result;
    }

    @Transactional
    public Result<PayProject> selectById(int id) {
        Result<PayProject> result = new Result<>();
        PayProject payProject = payProjectMapper.selectById(id);
        if (payProject == null) {
            result.setCode(Result.ERROR);
            result.setMsg("未查询到id为：" + id + "的项目");
            return result;
        }
        result.setCode(Result.OK);
        result.setMsg("查询项目成功");
        result.setData(payProject);
        return result;
    }

    @Transactional
    public Result<PayProject> selectByName(String name) {
        Result<PayProject> result = new Result<>();
        PayProject payProject = payProjectMapper.selectByName(name);
        if (payProject == null) {
            result.setCode(Result.ERROR);
            result.setMsg("未查询到名称为：" + name + "的项目");
            return result;
        }
        result.setCode(Result.OK);
        result.setMsg("查询项目成功");
        result.setData(payProject);
        return result;
    }

    @Transactional
    public Result<?> insertPayProject(PayProject payProject) {
        Result<?> result = new Result<>();
        if (payProject.getPayProjectId() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目id不能为空");
            return result;
        }
        if (payProject.getProjectName() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目名称不能为空");
            return result;
        }
        if (payProject.getProjectPrice() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目价格不能为空");
            return result;
        }

        payProjectMapper.insertPayProject(payProject);
        result.setCode(Result.OK);
        result.setMsg("新增项目成功");
        return result;
    }

    @Transactional
    public Result<?> deletePayProject(int id) {
        Result<?> result = new Result<>();
        payProjectMapper.deletePayProject(id);
        result.setCode(Result.OK);
        result.setMsg(":删除项目成功！");
        return result;
    }

    public Result<?> updatePayProject(PayProject payProject) {
        Result<?> result = new Result<>();
        if (payProject.getPayProjectId() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目id不能为空");
            return result;
        }
        if (payProject.getProjectName() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目名称不能为空");
            return result;
        }
        if (payProject.getProjectPrice() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目价格不能为空");
            return result;
        }
        payProjectMapper.updatePayProject(payProject);
        result.setCode(Result.OK);
        result.setMsg("新增项目成功");
        return result;
    }


}
