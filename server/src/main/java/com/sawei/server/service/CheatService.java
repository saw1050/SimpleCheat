package com.sawei.server.service;

import java.util.Date;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sawei.server.mappers.CheatMapper;
import com.sawei.server.receive.LoginForm;
import com.sawei.server.receive.RegisterForm;
import com.sawei.server.response.FriendshipResult;
import com.sawei.server.response.LoginResult;
import com.sawei.server.response.MessagesResult;
import com.sawei.server.response.SelfInformationResult;
import com.sawei.server.sql.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheatService {
    @Autowired
    private CheatMapper mapper;

    @Autowired
    private Algorithm algorithm;

    public boolean registeredResult(RegisterForm form){
        try {
            mapper.registered(form);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public LoginResult loginResult(LoginForm form){
        List<String> result = mapper.getPassword(form.getUsername());
        if(result == null || result.size() == 0)
            return new LoginResult(LoginResult.USERNAME, null);
        else if(result.get(0).equals(form.getPassword()) == false)
            return new LoginResult(LoginResult.PASSWORD, null);
        else
        {
            String token = JWT.create()
                            .withClaim("username", form.getUsername())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 60*1000))
                            .sign(algorithm);
            return new LoginResult(LoginResult.SUCCEED, token);
        }
    }

    public SelfInformationResult selfInformationResult(String username){
        return new SelfInformationResult(true,mapper.getUser(username).get(0));
    }

    public FriendshipResult friendshipResult(String master){
        return new FriendshipResult(true,mapper.getFriends(master));
    }

    public MessagesResult messagesResult(String dst){
        List<Message> messages = mapper.getMessageByDestination(dst);
        mapper.clearMessageByDestination(dst);
        return new MessagesResult(true,messages);
    }

    public DecodedJWT validateResult(String token){
        try {
            return JWT.require(algorithm).build().verify(token);
        } catch (Exception e) {
            return null;
        }
    }

}
