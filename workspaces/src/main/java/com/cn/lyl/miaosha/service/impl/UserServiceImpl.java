package com.cn.lyl.miaosha.service.impl;

import com.cn.lyl.miaosha.dao.UserDOMapper;
import com.cn.lyl.miaosha.dao.UserPasswordDOMapper;
import com.cn.lyl.miaosha.dataobject.UserDO;
import com.cn.lyl.miaosha.dataobject.UserPasswordDO;
import com.cn.lyl.miaosha.service.UserService;
import com.cn.lyl.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;
    @Override
    public UserModel getUserById(Integer id) {
        //调用userDOMapper获取到对应的用户dataobject
        UserDO userDO=userDOMapper.selectByPrimaryKey(id);
        if (userDO==null)
        {
            return null;
        }
        UserPasswordDO userPasswordDO=userPasswordDOMapper.selectByUserId(userDO.getId());

        return convertFromDataObject(userDO,userPasswordDO);

    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
        if (userDO==null){
            return null;
        }

        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(userDO,userModel);

        if (userPasswordDO!=null){
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
