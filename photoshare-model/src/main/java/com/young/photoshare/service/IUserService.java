package com.young.photoshare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.photoshare.entity.User;
import com.young.photoshare.utils.R;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author young
 * @since 2019-04-21
 */
public interface IUserService extends IService<User> {

    R getUserInfoList();
}
