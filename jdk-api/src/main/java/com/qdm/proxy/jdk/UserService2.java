package com.qdm.proxy.jdk;

/**
 * @author qiudm
 * @date 2018/8/15 15:16
 * @desc
 */
public class UserService2 implements IUserService {
    @Override
    public String getUserName(String name) {
        System.out.println(" get userName2 ");
        return "useName2";
    }
}
