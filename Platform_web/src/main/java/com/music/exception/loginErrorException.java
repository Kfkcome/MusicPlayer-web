package com.music.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class loginErrorException extends Exception{
    public loginErrorException(String a)
    {
        super(a);
    }

}
