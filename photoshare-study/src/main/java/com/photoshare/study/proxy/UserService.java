package com.photoshare.study.proxy;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * 动态代理学习
 * <p>
 * 用户接口
 */
public interface UserService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param pwd      密码
     * @return
     */
    boolean login(String username, String pwd);

    /**
     * 退出
     */
    void logout(String username);

    R getUserInfoList();
}
