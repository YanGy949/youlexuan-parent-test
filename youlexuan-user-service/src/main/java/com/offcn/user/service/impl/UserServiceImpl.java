package com.offcn.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.entity.PageResult;
import com.offcn.mapper.TbUserMapper;
import com.offcn.pojo.TbUser;
import com.offcn.pojo.TbUserExample;
import com.offcn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public PageResult findAll(TbUser tbUser, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        if (tbUser != null) {
            if (tbUser.getUsername() != null && tbUser.getUsername().length() > 0) {
                criteria.andUsernameLike("%" + tbUser.getUsername() + "%");
            }
            if (tbUser.getSourceType() != null && tbUser.getSourceType().length() > 0) {
                criteria.andSourceTypeEqualTo(tbUser.getSourceType());
            }
        }
        Page<TbUser> page = (Page<TbUser>) tbUserMapper.selectByExample(tbUserExample);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(TbUser tbUser) {
        tbUserMapper.insert(tbUser);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            tbUserMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbUser findOne(Long id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserMapper.updateByPrimaryKey(tbUser);
    }
}
