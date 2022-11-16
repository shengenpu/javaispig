package com.example.javaispig.serive;

import com.example.javaispig.entity.user;
import org.springframework.stereotype.Service;

@Service
public interface Gorelize {
    user findUserqname(String userqname);
    user findByEmail(String email);
    user findByphone(String phone);
//    user gofindAll(String userqname);

    user goup(String userid, String password);
}
