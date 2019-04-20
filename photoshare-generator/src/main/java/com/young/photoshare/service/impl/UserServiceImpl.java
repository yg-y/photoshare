package com.young.photoshare.service.impl;

import com.young.photoshare.entity.User;
import com.young.photoshare.mapper.UserMapper;
import com.young.photoshare.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author young
 * @since 2019-04-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
