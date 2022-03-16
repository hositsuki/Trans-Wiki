package org.wiki.trans_wiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wiki.trans_wiki.service.ArticleService;
import org.wiki.trans_wiki.vo.ArticleVo;
import org.wiki.trans_wiki.vo.Result;
import org.wiki.trans_wiki.vo.params.PageParams;

import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * @Author 月下夜桜夢
     * @Description 首页文章列表
     * @Date 10:59 2022/03/09
     * @Param [pageParams]
     * @return org.wiki.trans_wiki.vo.Result
     **/
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticle(pageParams);

        return Result.success(articles);
    }
}
