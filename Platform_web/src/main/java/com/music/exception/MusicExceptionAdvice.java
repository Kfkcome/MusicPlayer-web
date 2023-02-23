package com.music.exception;

import com.music.domain.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

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
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public ResponseResult handlerDoubleAdd(){//处理重复加入歌单的错误
        return new ResponseResult(401,"歌曲已经在歌单中，请不要重复加入");
    }
}
