package com.music.exception;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
public class loginErrorException extends JwtException {
    public loginErrorException(String mes)
    {
        super(mes);
    }
}
