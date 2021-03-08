package com.sawei.server.response;

import com.sawei.server.sql.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelfInformationResult {
    private boolean result;
    private User information;
}
