package com.example.javaispig.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.javaispig.entity.user;
import com.example.javaispig.error.Result;
import com.example.javaispig.serive.Gorelize;
import com.example.javaispig.serive.Jpaseriveuser;
import com.example.javaispig.serive.MD5;
import com.example.javaispig.serive.relize.UserSerive;
import com.example.javaispig.session.tokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@ResponseBody
public class login {
    @Autowired
    private Jpaseriveuser jpaseriveuser;
    @Resource
    @Autowired
    private Gorelize userSerive;
    @CrossOrigin
    @GetMapping("/api/login")
    @ResponseBody
    public Result logincnm() {
        return Result.error("10001", "request not logged in");
    }
    @CrossOrigin
    @PostMapping("/api/login")
    @ResponseBody
    public JSONObject login01(@RequestParam("userid") String userid,
                        @RequestParam("password") String password) {
        MD5 md5=new MD5();
        String md5pass = md5.MD5use(password);
        JSONObject jsonObject=new JSONObject();
        user a = userSerive.goup(userid,md5pass);//a用于检测数据库中是否存在账号密码

        if (a == null) {
            jsonObject.put("code","500");
            jsonObject.put("msg","login fail");
            return jsonObject;
        } else {
            String token= tokenUtil.sign(a);
            jsonObject.put("token",token);
            jsonObject.put("user",a);
            jsonObject.put("msg","login success");
            jsonObject.put("code",200);
            return jsonObject;
       }
    }
    @GetMapping("/api/logout")
    public JSONObject logout() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("msg","logout success!");
        return jsonObject;

    }
}
