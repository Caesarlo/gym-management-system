package com.gym.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 用户实体类
 * @create: 2022-11-19 13:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User_temp {

    //用户id
    @NotNull(message = "用户id不能为空！")
    private int userId;

    //用户名
    @NotNull(message = "用户名不能为空！")
    private String userName;

    //用户密码
    @NotNull(message = "用户密码不能为空！")
    private String passWord;

    //最后登录时间
    private Timestamp lastLoginTime;

    //登录次数
    private Integer loginCount;

    //联系电话
    @NotNull(message = "会员电话不能为空")
    @Length(min = 11, max = 11, message = "电话号码长度为11位有效数字！")
    @Pattern(regexp = "^1[34578]\\d{9}$", message = "不符合规格的手机号码!")
    private String phoneNumber;

    //年龄
    private Integer age;

    //姓名
    private String name;

    //角色
    private Integer role;

}
