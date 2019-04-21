package com.photoshare.study.proxy;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * 动态代理学习
 * <p>
 * 用户接口实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String pwd) {
        // 简化问题，直接登录成功
        System.out.println(username + " 登录成功.");
        return true;
    }

    @Override
    public void logout(String username) {
        System.out.println(username + " 成功退出.");
    }

    @Override
    public R getUserInfoList() {
        return null;
    }
}
