package com.sawei.server.mappers;

import java.util.List;

import com.sawei.server.receive.RegisterForm;
import com.sawei.server.sql.Friendship;
import com.sawei.server.sql.Message;
import com.sawei.server.sql.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheatMapper {
    // 查询
    public List<String> getPassword(String username);

    public List<User> getUser(String username);

    public List<Message> getMessageByDestination(String dst);
    public List<Message> getMessageBySource(String src);

    public List<Friendship> getFriends(String master);

    // 插入
    public void registered(RegisterForm form);

    // 删除
    public void clearMessageByDestination(String dst);
}
