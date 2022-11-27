package com.gym.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练实体类
 * @create: 2022-11-17 11:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coach implements Serializable {
    //教练id
    @NotNull(message = "教练编号为空！")
    private String coachId;

    //教练姓名
    @NotNull(message = "姓名为空！")
    private String coachName;

    //教练身高
    private String coachHeight;

    //体重
    private String coachWeight;

    //教练头像
    private String coachHeader;


}
