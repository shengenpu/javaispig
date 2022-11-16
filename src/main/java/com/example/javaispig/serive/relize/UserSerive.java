package com.example.javaispig.serive.relize;

import com.example.javaispig.entity.user;
import com.example.javaispig.serive.Gorelize;
import com.example.javaispig.serive.Jpaseriveuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class UserSerive implements Gorelize {
    @Autowired
    private Jpaseriveuser jpaseriveuser;

    @Override
    public user findUserqname(String userid) {
        return jpaseriveuser.findByUserid(userid);
    }

    @Override
    public user findByEmail(String email) {
        return jpaseriveuser.findByEmail(email);
    }

    @Override
    public user findByphone(String phone) {
        return jpaseriveuser.findByPhone(phone);
    }

//    @Override
//    public user gofindAll(String userqname) {
//        return jpaseriveuser.findAll(userqname);
//    }

    @Override
    public user goup(String userid, String password) {
        return jpaseriveuser.findByUseridAndPassword(userid,password);
    }
}
