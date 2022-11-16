package com.example.javaispig.controller;

//import com.example.javaispig.serive.jpaserivebuy;
import org.springframework.web.bind.annotation.*;

@RestController
public class index {
//    @Autowired
//    @Resource
//    private Gorelize gorelize;
//    private time time;
    @CrossOrigin
    @GetMapping ("/index")
    @ResponseBody
    //在主页买东西咯~~~~~~~~~~
    public String buy(){
        return "hello,world!!!!!!!!!!!!!!!!!!!!!!!!";
    }
}
