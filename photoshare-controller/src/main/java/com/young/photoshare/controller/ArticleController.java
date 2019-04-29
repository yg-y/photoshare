package com.young.photoshare.controller;


import com.young.photoshare.entity.Article;
import com.young.photoshare.service.IArticleService;
import com.young.photoshare.utils.R;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ArticleController {

    @Autowired
    private IArticleService iArticleServiceImpl;

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
        R r;
        try {
            r = iArticleServiceImpl.getArticleInfo(article.getId());
        } catch (Exception e) {
            r = R.error("服务器异常，请稍后再试");
            log.error("服务器异常: " + e.toString());
        }
        return r;
    }

}
