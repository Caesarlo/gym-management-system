package com.gym.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员实体类
 * @create: 2022-11-18 22:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    //会员id
    @NotNull(message = "会员id不难为空！")
    private Integer memberId;

    //会员编号
    @NotNull(message = "会员编号不能为空！")
    private String memberNumber;


    //会员密码
    @NotNull(message = "会员密码不难为空！")
    private String memberPassword;

    //会员姓名
    @NotNull(message = "会员姓名不难为空！")
    private String memberName;

    //会员性别
    private String memberSex;

    //会员类型
    @NotNull(message = "会员类型不能为空！")
    private String memberType;

    //会员生日
    private Date memberBirth;

    //联系电话
    @NotNull(message = "会员电话不能为空")
    @Length(min = 11,max = 11,message = "电话号码长度为11位有效数字！")
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "不符合规格的手机号码!")
    private String memberPhone;

    //住址
    private String memberAddress;

    //初始时间
    @NotNull(message = "注册时间为空！")
    private Date memberStartTime;

    //到期时间
    @NotNull(message = "到期时间为空！")
    private Date memberEndTime;

}
