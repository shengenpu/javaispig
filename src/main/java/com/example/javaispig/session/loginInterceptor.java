//package com.example.javaispig.session;
//
//import com.example.javaispig.entity.user;
//import com.example.javaispig.serive.Jpaseriveuser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.annotation.Resource;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////配置拦截器
//@Component
//public class loginInterceptor implements HandlerInterceptor {
//    @Autowired
//    @Resource
//    private Jpaseriveuser jpaseriveuser;
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object Handler)throws Exception{
//        //获取cookie
//        Cookie[] cookies=request.getCookies();
//        //没有cookie，重定向login
//        if(cookies==null){
//            response.sendRedirect(request.getContextPath()+"/login");
//            return false;
//        }
//        String cookie_name=null;
//        for(Cookie items:cookies){
//            if("cookie_name".equals(items.getName())){
//                cookie_name= items.getValue();
//                break;
//            }
//        }
//        if(StringUtils.isEmpty(cookie_name)){
//            response.sendRedirect(request.getContextPath()+"/login");
//            return false;
//        }
//        HttpSession session=request.getSession();
//        Object obj=session.getAttribute("users");
//        if(null==obj){
//            user user=jpaseriveuser.findByUserid(cookie_name);
//            session.setAttribute("users",user);
//        }
//        return true;
//    }
//}
