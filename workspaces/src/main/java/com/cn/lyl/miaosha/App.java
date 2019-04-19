package com.cn.lyl.miaosha;

import com.cn.lyl.miaosha.dao.UserDOMapper;
import com.cn.lyl.miaosha.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
//@EnableAutoConfiguration//自动化配置
@SpringBootApplication(scanBasePackages = {"com.cn.lyl.miaosha"})
@RestController
@MapperScan("com.cn.lyl.miaosha.dao")
public class App 
{
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO=userDOMapper.selectByPrimaryKey(1);
        if(userDO==null)
        {
            return "用户对象不存在";
        }else {
            return userDO.getName();
        }
//        return "hello,lixiang3!";
    }
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
