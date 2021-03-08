package com.sawei.server.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResult {
    private String result;
    private String token;
    public static final String SUCCEED = "succeed";
    public static final String PASSWORD = "error_pwd";
    public static final String USERNAME = "error_usr";
}
