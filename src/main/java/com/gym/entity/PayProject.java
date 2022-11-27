package com.gym.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 付费课程实体
 * @create: 2022-11-20 14:59
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayProject {
    //项目id 自增
    @NotNull(message = "课程id为空！")
    private Integer payProjectId;

    //项目名称
    @NotNull(message = "课程名不能为空！")
    private String projectName;

    //项目价格
    @NotNull(message = "项目价格不能为空！")
    private BigDecimal projectPrice;

    //项目日期
    private Timestamp projectTime;

    //项目简述
    private String projectContent;
}
