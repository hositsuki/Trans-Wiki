package org.wiki.trans_wiki.service;

import org.wiki.trans_wiki.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);
}
