package com.young.photoshare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.photoshare.entity.Article;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author young
 * @since 2019-04-23
 */
public interface ArticleMapper extends BaseMapper<Article> {

    List<Article> getHomeList();
}
