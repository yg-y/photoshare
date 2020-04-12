package com.photoshare.study.cglb;

public class UserController {
    public static void main(String[] args) {
        IUserService iUserService = new CGLIBProxy().getInstance(UserServiceImpl.class);

        iUserService.login("young");
    }
}
