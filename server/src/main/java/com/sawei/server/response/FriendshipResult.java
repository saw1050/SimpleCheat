package com.sawei.server.response;

import java.util.List;

import com.sawei.server.sql.Friendship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipResult {
    private boolean result;
    private List<Friendship> friends;
}
