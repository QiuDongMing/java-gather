package com.qdm.proxy.jdk;

/**
 * @author qiudm
 * @date 2018/8/15 14:49
 * @desc
 */
public class UserService implements IUserService {


    public String getUserName() {
        System.out.println("get userName" );
        return "userName";
    }



}
