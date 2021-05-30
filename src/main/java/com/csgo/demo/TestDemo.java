package com.csgo.demo;

import com.csgo.po.Weapontype;
import com.csgo.service.WeaponTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
*测试spring能否进行

 */
public class TestDemo {


    @Test
    public void testSpring()
    {
        //获取spring文件
        ApplicationContext app= new ClassPathXmlApplicationContext("spring.xml");
        //获取bean
        WeaponTypeService t= (WeaponTypeService) app.getBean("WeaponTypeService");


    }


}
