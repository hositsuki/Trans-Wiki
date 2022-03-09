package org.wiki.trans_wiki.service.impl;

import org.springframework.stereotype.Service;
import org.wiki.trans_wiki.dao.mapper.SysUserMapper;
import org.wiki.trans_wiki.dao.pojo.SysUser;
import org.wiki.trans_wiki.service.SysUserService;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("默认");
        }
        return sysUser;
    }
}
