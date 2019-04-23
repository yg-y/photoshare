package com.young.photoshare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.photoshare.entity.Article;
import com.young.photoshare.utils.R;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author young
 * @since 2019-04-23
 */
public interface IArticleService extends IService<Article> {

    R getHomeList();
}
