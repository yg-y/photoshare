package com.young.photoshare.controller;


import com.young.photoshare.entity.Article;
import com.young.photoshare.service.IArticleService;
import com.young.photoshare.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/photoshare/article")
public class ArticleController {

    @Autowired
    IArticleService iArticleServiceImpl;

    @GetMapping("/list")
    public R getHomeList() {
        return iArticleServiceImpl.getHomeList();
    }

    /**
     * 根据ID获取文章详情
     *
     * @param article
     * @return
     */
    @PostMapping("/getArticleInfo")
    public R getArticleInfo(@RequestBody Article article) {
        return iArticleServiceImpl.getArticleInfo(article.getId());
    }

}
