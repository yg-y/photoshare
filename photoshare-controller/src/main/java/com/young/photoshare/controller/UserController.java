package com.young.photoshare.controller;

import com.young.photoshare.service.IUserService;
import com.young.photoshare.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2019-04-21
 */
@RestController
@RequestMapping("/photoshare/user")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    @GetMapping("/list")
    public R getUserInfoList() {
        return userServiceImpl.getUserInfoList();
    }
}
