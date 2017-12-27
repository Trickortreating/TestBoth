package com.model;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class Main {






    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;



    @Before//初始化方法
    public void init(){

        //创建配置对象
        Configuration configuration=new Configuration().configure();
        //创建服务注册对象
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session=sessionFactory.openSession();
        //开启事务
        transaction=session.beginTransaction();
    }
    @Test //测试方法
    public void testsave(){
        //生成学生对象
        User u=new User(1001, "小红", "123", 20, "123@qq.com");
        session.save(u);

    }
    @After//释放资源
    public void destory(){

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}