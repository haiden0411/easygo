package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-09-19 22:58
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable
{
    private static final long serialVersionUID = -6374058687739322639L;
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String created;
    private String updated;
    private String source_type;
    private String nick_name;
    private String name;
    private String status;
    private String head_pic;
    private String qq;
    private double account_balance;
    private String is_email_check;
    private String is_mobile_check;
    private String sex;
    private Integer user_level;
    private Integer points;
    private Integer experience_value;
    private String birthday;
    private String last_login_time;
    private Integer del;
}
