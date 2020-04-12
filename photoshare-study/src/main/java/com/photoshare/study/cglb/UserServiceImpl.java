package com.photoshare.study.cglb;

public class UserServiceImpl implements IUserService {
    @Override
    public void login(String username) {
        System.err.println("login in " + username);
    }
}
