package com.gym.dao;


import com.gym.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user order by id asc")
    @Results({
           @Result(property = "lastLoginTime",column = "last_login_time"),
            @Result(property = "loginCount",column = "login_count")
    })
    public List<User> selectAllUser();  // 查询所有数据


    @Select("<script>select * from user where 1=1 " +
            "<if test='stime!=null and stime!=\"\"'> and last_login_time&gt;#{stime} </if>" +
            "<if test='etime!=null and etime!=\"\"'> and last_login_time&lt;#{etime} </if>" +
            "<if test='idUsername!=null and idUsername!=\"\"'> and (id like #{idUsername}" +
            " or username like #{idUsername}) </if>" +
            "order by id asc limit #{start},#{end} </script>")
    @Results({
            @Result(property = "lastLoginTime",column = "last_login_time"),
            @Result(property = "loginCount",column = "login_count")
    })
    public  List<User> selectLimitUser(@Param("start") int start,@Param("end") int end,@Param("stime") String stime,
                                       @Param("etime") String etime,@Param("idUsername") String idUsername);  // 查询start到end数据[start,end)
    @Update("<script>update user " +
            "<trim prefix='set ' suffixOverrides=','>" +
            "id = #{id}," +
            "<if test='username!=null and username!=\"\"'> username=#{username},</if>" +
            "<if test='password!=null and password!=\"\"'>password=#{password},</if>" +
            "<if test='time!=null and time!=\"\"'>last_login_time=#{time},</if>" +
            "<if test='loginCount!=null and loginCount!=\"\"'>login_count=#{loginCount},</if>" +
            "<if test='phone!=null and phone!=\"\"'>phone=#{phone},</if>" +
            "<if test='age!=null and age!=\"\"'>age=#{age},</if>" +
            "<if test='name!=null and name!=\"\"'>name=#{name},</if>" +
            "<if test='role!=null and role!=\"\"'>role=#{role}</if> " +
            "</trim> where id=#{id} </script>")
    public int updateUserByID(@Param("id")long id,@Param("username")String username,@Param("password")String passowrd,
                              @Param("time")String time,@Param("loginCount")long loginCount,@Param("phone")String phone,
                              @Param("age")long age,@Param("name")String name,@Param("role")String role);
    @Delete("delete from user where id=#{id}")
    public int deleteUserByID(int id);
    @Select("select * from user where username=#{username} and password=#{password}")
    @Results({
            @Result(property = "lastLoginTime",column = "last_login_time"),
            @Result(property = "loginCount",column = "login_count")
    })
    public User selectUserByLogin(@Param("username")String username,@Param("password")String password);
//    @Insert("insert into user value(username=#{username},password=#{password},last_login_time=#{lastLoginTime}," +
//            "login_count=#{loginCount},phone=#{phone},age=#{age},name=#{name},role=#{role})")
    @Insert("<script>insert into user(username,password,last_login_time,login_count,phone,age,name,role) value" +
            "<trim prefix='(' suffixOverrides=','>" +
            "<if test='username!=null and username!=\"\"'> #{username},</if>" +
            "<if test='password!=null and password!=\"\"'>#{password},</if>" +
            "<if test='time!=null and time!=\"\"'>#{time},</if>" +
            "0," +
            "<if test='phone!=null and phone!=\"\"'>#{phone},</if>" +
            "<if test='age!=null and age!=\"\"'>#{age},</if>" +
            "<if test='name!=null and name!=\"\"'>#{name},</if>" +
            "<if test='role!=null and role!=\"\"'>#{role}</if> " +
            "</trim>  )" +
            "</script>")
    public int insertUser(@Param("username")String username,@Param("password")String passowrd,
                          @Param("time")String time,@Param("phone")String phone,
                          @Param("age")long age,@Param("name")String name,@Param("role")String role);


}
