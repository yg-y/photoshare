package com.young.photoshare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.photoshare.entity.Article;
import com.young.photoshare.mapper.ArticleMapper;
import com.young.photoshare.service.IArticleService;
import com.young.photoshare.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author young
 * @since 2019-04-23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public R getHomeList() {
        List<Article> articles = articleMapper.getHomeList();
        return R.success(articles);
    }
}
