package com.music.controller;

import com.music.domain.Mv;
import com.music.domain.ResponseResult;
import com.music.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/mv")
public class MvController {
    @Autowired
    private MvService mvService;
    @RequestMapping("/random")
    public ResponseResult<List> findRandomMv() throws NoSuchAlgorithmException {
        return new ResponseResult<>(200,"传输成功",mvService.findRandomMv());
    }
    @RequestMapping("/select")
    public ResponseResult<Mv> findMvByID(@RequestBody Mv mv)
    {
        return new ResponseResult<>(200,"传输成功",mvService.findMvByID(mv.getMvID()));
    }
}
