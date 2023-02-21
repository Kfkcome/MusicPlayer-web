package com.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;//用户id
    private String uid;//用户登录账号
    private String password;//用户登录密码
}
