package com.music.exception;

import com.music.domain.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

@ControllerAdvice
public class MusicExceptionAdvice {
    @ExceptionHandler(NoSuchAlgorithmException.class)
    @ResponseBody
    public ResponseResult handlerException(Exception e) {
        String mes = e.getMessage();
        return new ResponseResult<>(401, mes);
    }

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseBody
    public ResponseResult handlerNotfound(Exception e) {
        String mes = e.getMessage();
        return new ResponseResult(401, mes);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public ResponseResult handlerIndexOutOfBound(){
        return new ResponseResult(401,"搜索不到请重新尝试");
    }
}
