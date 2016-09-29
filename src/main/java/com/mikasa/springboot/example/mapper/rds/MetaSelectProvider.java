package com.mikasa.springboot.example.mapper.rds;


/**
 * Created by sherlock on 16/9/12.
 */
public class MetaSelectProvider {

    private static final String USERSQL = "id,name,phone";

    public String getUserList() {
        org.apache.ibatis.jdbc.SQL sql = new org.apache.ibatis.jdbc.SQL();
        sql.SELECT(USERSQL).FROM("T_USER");//.WHERE("biz_id=#{xxxId}");
        return sql.toString();
    }
}
