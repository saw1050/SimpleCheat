package com.sawei.server.response;

import java.util.List;

import com.sawei.server.sql.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagesResult {
    private boolean result;
    private List<Message> messages;
}
