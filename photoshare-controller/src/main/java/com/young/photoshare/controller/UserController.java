package com.young.photoshare.controller;

import com.young.photoshare.entity.User;
import com.young.photoshare.service.IUserService;
import com.young.photoshare.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    public R getUserInfoList() {
        return userServiceImpl.getUserInfoList();
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return R.success(map);
    }

    @ApiOperation(value = "信息")
    @GetMapping("/info")
    public R info() {
        Map<String, Object> map = new HashMap<>();
        List<String> role = new ArrayList<>();
        role.add("admin");
        map.put("roles", role);
        return R.success(map);
    }

    @ApiOperation(value = "登出")
    @PostMapping("/logout")
    public R logout() {
        return R.success();
    }
}
