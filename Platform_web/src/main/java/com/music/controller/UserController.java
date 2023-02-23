package com.music.controller;

import com.music.domain.*;
import com.music.exception.loginErrorException;
import com.music.service.UserService;
import com.music.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.music.utils.JwtUtil.createJWT;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    @CrossOrigin
    public ResponseResult login(@RequestBody User user)
    {
        String token=userService.login(user);
        //校验用户名密码是否正确
        if (token!=null) {
            return new ResponseResult(200, "登录成功", token);
        } else {
            //如果不正确 给出相应的提示
            return new ResponseResult(300, "用户名或密码错误，请重新登录");
        }
    }
    @RequestMapping("/info")
    public ResponseResult findUserInfoById(HttpServletRequest request) throws loginErrorException {
        String token=request.getHeader("token");
        Claims claims=JwtUtil.parseJWT(token);
        String id=claims.getSubject();
        return new ResponseResult(200,"传输成功",userService.findUserInfoById(Integer.valueOf(id)));
    }
    @RequestMapping("/info/update")
    public ResponseResult updateUserInfoById(HttpServletRequest request, @RequestBody UserInfo userInfo)
    {
        String token=request.getHeader("token");
        Claims claims=JwtUtil.parseJWT(token);
        String id=claims.getSubject();
        if(userService.updateUserInfoById(Integer.valueOf(id),userInfo))
        {
            return new ResponseResult(200,"修改成功");
        }
        return new ResponseResult(401,"修改失败");
    }
    @RequestMapping("/playlist")
    public ResponseResult findPlaylist(HttpServletRequest request)
    {
        String token=request.getHeader("token");
        Claims claims=JwtUtil.parseJWT(token);
        String id=claims.getSubject();
        return new ResponseResult(200,"传输成功",userService.findPlaylist(Integer.valueOf(id)));
    }
    @RequestMapping("/addplaylist")
    public ResponseResult addPlaylist(HttpServletRequest request,@RequestBody Playlist playlist)
    {
        String token=request.getHeader("token");
        Claims claims=JwtUtil.parseJWT(token);
        String id=claims.getSubject();
        return new ResponseResult(200,"增加成功",userService.addPlaylist(Integer.valueOf(id),playlist));
    }
    @RequestMapping("/playlist/add")
    public ResponseResult addSongToPlaylist(@RequestBody PlaylistSong playlistSong)
    {
        return new ResponseResult(200,"添加成功",userService.addPlaylistSong(playlistSong));
    }
    @RequestMapping("/playlist/delete")
    public ResponseResult deleteSongInPlaylist(@RequestBody PlaylistSong playlistSong)
    {
        return new ResponseResult(200,"删除成功",userService.deletePlaylistSong(playlistSong));
    }

}
