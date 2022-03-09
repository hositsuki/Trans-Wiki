package org.wiki.trans_wiki.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wiki.trans_wiki.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long articleId);
}
