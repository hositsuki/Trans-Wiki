package org.wiki.trans_wiki.service;

import org.wiki.trans_wiki.dao.pojo.SysUser;

public interface SysUserService {

    SysUser findUserById(Long id);
}
