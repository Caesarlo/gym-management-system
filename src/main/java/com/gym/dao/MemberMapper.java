package com.gym.dao;

import com.gym.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员持久层接口
 * @create: 2022-11-18 22:49
 **/
@Mapper
public interface MemberMapper {

    /**
     * 获取所有会员信息
     * @return 会员集合
     */
    List<Member> getAllMembers();

    /**
     * 通过会员id获取会员信息
     * @param id
     * @return 会员信息
     */
    Member getMemberById(String id);


    /**
     * 模糊查询会员信息
     * @param info
     * @return 所匹配的会员结果
     */
    List<Member> getMembersByVague(String info);

    /**
     * 获取所有的会员数量
     * @return 会员数量
     */
    Integer getAllMemberNumber();

    /**
     * 新增会员
     * @param member
     */
    void insertMember(Member member);


    /**
     * 根据会员id修改会员信息
     * @param member
     */
    void updateMember(Member member);

    /**
     * 根据会员id删除会员
     * @param id
     */
    void deleteMember(Integer id);

    /**
     * 批量注册会员
     * @param members
     */
    void insertMemberByBatch(List<Member> members);

    /**
     * 通过电话号码查会员id
     * @param memberPhone
     * @return
     */
    String selectIdByTel(String memberPhone);

}
