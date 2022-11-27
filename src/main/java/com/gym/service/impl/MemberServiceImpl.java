package com.gym.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.MemberMapper;
import com.gym.entity.Member;
import com.gym.entity.Result;
import com.gym.exception.PageNumberException;
import com.gym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员服务层实现
 * @create: 2022-11-27 11:24
 **/
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Result<PageInfo<Member>> getMemberByPage(Integer startPage, Integer pageSize) {
        if (startPage < 1) {
            throw new PageNumberException("起使页码无效~");
        }
        Page<Member> page = PageHelper.startPage(startPage, pageSize);
        List<Member> members = memberMapper.getAllMembers();
        PageInfo<Member> pageInfo = new PageInfo<>(members);
        return new Result<PageInfo<Member>>(Result.OK, "查询成功", pageInfo);
    }

    @Override
    public Result deleteMember(String id) {
        memberMapper.deleteMember(id);
        return new Result(Result.OK,"删除成功");
    }

    @Override
    public Result updateMember(Member member) {
        memberMapper.updateMember(member);
        return new Result(Result.OK,"修改成功");
    }

    @Override
    public Result insertMember(Member member) {
        memberMapper.insertMember(member);
        return new Result(Result.OK,"注册成功");
    }

    @Override
    public Result getMemberById(String id) {
        Member member=memberMapper.getMemberById(id);
        return new Result<Member>(Result.OK,"请求成功",member);
    }

    @Override
    public Result getMemberByKeyword(Integer startPage, Integer pageSize, String keyword) {
        if (startPage < 1) {
            throw new PageNumberException("起使页码无效~");
        }
        Page<Member> page=PageHelper.startPage(startPage,pageSize);
        List<Member> members=memberMapper.getMembersByVague(keyword);
        PageInfo<Member> pageInfo=new PageInfo<>(members);
        return new Result<PageInfo<Member>>(Result.OK,"查询成功",pageInfo);
    }
}
