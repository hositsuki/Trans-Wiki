package org.wiki.trans_wiki.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.wiki.trans_wiki.dao.mapper.TagMapper;
import org.wiki.trans_wiki.dao.pojo.Tag;
import org.wiki.trans_wiki.service.TagService;
import org.wiki.trans_wiki.vo.TagVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    private List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;

    }

    private TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }
}
