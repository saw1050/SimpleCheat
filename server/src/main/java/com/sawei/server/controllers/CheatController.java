package com.sawei.server.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sawei.server.DataStruct.FriendListResult;
import com.sawei.server.DataStruct.LoginForm;
import com.sawei.server.DataStruct.LoginResult;
import com.sawei.server.DataStruct.RegisterForm;
import com.sawei.server.service.CheatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CheatController {
    @Autowired
    private CheatService service;

    @PostMapping("/login")
    public LoginResult login(@RequestBody LoginForm form){
        return service.loginResult(form);
    }

    @GetMapping("/login/{token}")
    public boolean validateToken(@PathVariable String token){
        if(service.validateResult(token) == null)
            return false;
        return true;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody RegisterForm form){
        return service.registeredResult(form);
    }

    @GetMapping("/friendlist/{token}")
    public FriendListResult friendList(@PathVariable String token){
        DecodedJWT jwt = service.validateResult(token);
        if(jwt == null)
            return new FriendListResult(false, null);
        String username = jwt.getClaim("username").asString();
        
    }

    @PostMapping("/test")
    public Map<String,List<String>> test(@RequestBody Map<String,List<Integer>> map){
        System.out.println(map.get("list"));
        Map<String,List<String>> res = new HashMap<String,List<String>>();
        List<String> first = new ArrayList<String>();
        first.add("a");
        first.add("b");
        first.add("c");
        res.put("first", first);
        res.put("second", new ArrayList<String>());
        return res;
    }
}
