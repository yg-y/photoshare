package com.young.photoshare.controller;

import com.young.photoshare.entity.User;
import com.young.photoshare.service.IUserService;
import com.young.photoshare.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2019-04-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    @GetMapping("/list")
    public R getUserInfoList() {
        return userServiceImpl.getUserInfoList();
    }

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return R.success(map);
    }

    @GetMapping("/info")
    public R info() {
        Map<String, Object> map = new HashMap<>();
        List<String> role = new ArrayList<>();
        role.add("admin");
        map.put("roles", role);
        return R.success(map);
    }

    @PostMapping("/logout")
    public R logout() {
        return R.success();
    }
}
