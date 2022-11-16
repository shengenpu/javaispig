package com.example.javaispig.serive;

import com.example.javaispig.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface Jpaseriveuser extends JpaRepository<user,Integer> {
    user findByUserid(String userid);//找名字用于注册名唯一性
    user findByEmail(String email);//找邮箱保证注册邮箱唯一性
    user findByPhone(String phone);//找手机号保证注册手机号唯一性
//    user findAll(String userqname);
    user findByUseridAndPassword(String userid,String password);//找账号密码用于登录
}
