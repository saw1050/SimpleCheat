package com.sawei.server.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {
    private String username;
    private String alias;
    private String snap;
    private String name;
}
