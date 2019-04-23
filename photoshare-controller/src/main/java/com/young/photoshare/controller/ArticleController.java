package com.young.photoshare.controller;


import com.young.photoshare.service.IArticleService;
import com.young.photoshare.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
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

}
