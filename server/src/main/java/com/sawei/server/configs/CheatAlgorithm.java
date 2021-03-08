package com.sawei.server.configs;

import java.util.Random;

import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "webcheat.algorithm")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheatAlgorithm {
    private String secret;
    private int length;

    @Bean
    public Algorithm get(){
        int realLength = (this.length < 256)?(256>>3):(this.length>>3);
        if(this.secret == null)
        {
            Random rd =new Random();
            byte[] bytes = new byte[realLength];
                for(int i=0; i<realLength; i++)
                    bytes[i] = (byte)(rd.nextInt(93)+33);
            this.secret = new String(bytes);
        }
        System.out.println("请不要将该密钥告诉他人 "+this.secret);
        switch (this.length) {
            case 256:
                return Algorithm.HMAC256(this.secret);
            case 384:
                return Algorithm.HMAC384(this.secret);
            case 512:
                return Algorithm.HMAC512(this.secret);
            default:
                if(this.length < 256)
                    return Algorithm.HMAC256(this.secret);
                else if(this.length > 512)
                    return Algorithm.HMAC512(this.secret);
                else
                    return Algorithm.HMAC384(this.secret);
        }
    }
}
