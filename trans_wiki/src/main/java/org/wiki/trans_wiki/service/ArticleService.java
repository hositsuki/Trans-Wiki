package org.wiki.trans_wiki.service;

import org.wiki.trans_wiki.vo.Result;
import org.wiki.trans_wiki.vo.params.PageParams;

public interface ArticleService {
    /**
     * @Author 月下夜桜夢
     * @Description 分页查询 文章列表
     * @Date 11:12 2022/03/09
     * @Param [pageParams]
     * @return org.wiki.trans_wiki.vo.Result
     **/
    Result listArticle(PageParams pageParams);

}
