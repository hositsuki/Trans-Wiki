package org.wiki.trans_wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wiki.trans_wiki.dao.mapper.ArticleMapper;
import org.wiki.trans_wiki.dao.pojo.Article;
import org.wiki.trans_wiki.service.ArticleService;
import org.wiki.trans_wiki.service.SysUserService;
import org.wiki.trans_wiki.service.TagService;
import org.wiki.trans_wiki.vo.ArticleVo;
import org.wiki.trans_wiki.vo.params.PageParams;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<ArticleVo> listArticle(PageParams pageParams) {

        /**
         * @Author 月下夜桜夢
         * @Description 分页查询article数据表
         * @Date 11:25 2022/03/09
         * @Param [pageParams]
         * @return org.wiki.trans_wiki.vo.Result
         **/
        Page<Article> page = new Page<Article>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getWeight, Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList(records, true, true);

        return articleVoList;
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record, isTag, isAuthor));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm:ss"));
        if (isTag) {
            articleVo.setTags(tagService.findTagsByArticleId(article.getId()));
        }
        if (isAuthor) {
            articleVo.setAuthor(sysUserService.findUserById(article.getAuthorId()).getNickname());
        }
        return articleVo;
    }
}
