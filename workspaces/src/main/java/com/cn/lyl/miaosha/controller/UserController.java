package com.cn.lyl.miaosha.controller;

import com.cn.lyl.miaosha.controller.viewObject.UserVO;
import com.cn.lyl.miaosha.response.CommonReturnType;
import com.cn.lyl.miaosha.service.UserService;
import com.cn.lyl.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") Integer id){
        //调用service服务获取对应的id的用户对象并返回给前端
        UserModel userModel=userService.getUserById(id);
        //将核心领域模型用户对象转换为可供UI使用的viewobject
        UserVO userVO=convertFromModel(userModel);
        //返回通用对象
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel){
        if(userModel==null){
            return null;
        }
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
