package com.example.javaispig.controller;

import com.example.javaispig.entity.user;
import com.example.javaispig.error.Result;
import com.example.javaispig.serive.Gorelize;
import com.example.javaispig.serive.Jpaseriveuser;
import com.example.javaispig.serive.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@ResponseBody
public class registercontroller{
    MD5 md5=new MD5();
    user user=new user();
    @Resource
    @Autowired
    private Gorelize userSerive;
    @Autowired
    private Jpaseriveuser jpaseriveuser;
    @CrossOrigin
    @GetMapping("/api/register")
    public Result goregister(@RequestParam("userid") String userid,
                           @RequestParam("password") String password,
                           @RequestParam("sex") String sex,
                           @RequestParam("age") int age,
                           @RequestParam("email") String email,
                           @RequestParam("phone") String phone,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           HttpSession session){

        user byEmail = userSerive.findByEmail(email);
        user byphone = userSerive.findByphone(phone);
        user byname = userSerive.findUserqname(userid);

        if(userid.equals("")||password.equals("")||sex.equals("")||email.equals("")||phone.equals("")){
            return Result.error("10003","Be not empty");
        } else if (byname!=null) {
            return Result.error("10004","username is used");
        } else if (byphone!=null||byEmail!=null) {
            return Result.error("10004","phone or email is used");
        }else {
            String md5password = md5.MD5use(password);
            user.setUserid(userid);
            user.setEmail(email);
            user.setAge(age);
            user.setPhone(phone);
            user.setSex(sex);
            user.setPassword(md5password);
            jpaseriveuser.save(user);

        }
        return Result.success(user,"register successful!");
    }
}
