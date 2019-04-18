package com.cn.lyl.miaosha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration//自动化配置
@RestController
public class App 
{
    @RequestMapping("/")
    public String home(){
        return "hello,lixiang3!";
    }
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
