package com.example.javaispig.serive;

import java.util.Date;

public class time {
    public long gettime(){
        Date date=new Date();
        long time = date.getTime();
        return time;
    }

}
