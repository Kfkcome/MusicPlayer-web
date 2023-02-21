package com.music.controller;

import com.music.domain.ResponseResult;
import com.music.service.TestMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestMysql {
    @Autowired
    private TestMysqlService testMysqlService;
    @RequestMapping("/mysql")
    public ResponseResult FindUser()
    {
        return new ResponseResult<>(200,"成功",testMysqlService.FindUser().toString());
    }
}
