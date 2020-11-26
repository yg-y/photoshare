package com.single.login.single.service.impl;

import com.single.login.single.entity.TbUser;
import com.single.login.single.mapper.TbUserMapper;
import com.single.login.single.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2020-06-07
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
