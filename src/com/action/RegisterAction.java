package com.action;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import com.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import java.util.List;

public class RegisterAction extends ActionSupport {
    private User user;

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }

    @Override
    public String execute() throws Exception{
        return SUCCESS;
    }
    public String register() throws Exception{
        try{
            Session session=(Session) HibernateUtil.getSessionFactory();
            Transaction tx=session.beginTransaction();
            session.save(user);
            tx.commit();
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            HibernateUtil.getSessionFactory().close();
            return ERROR;
        }
    }

    public String login() throws Exception{
        try{
            Session session=(Session)HibernateUtil.getSessionFactory();
            Transaction tx=session.beginTransaction();
            Query query=session.createQuery("from User where username=:uname");
            List list=query.list();
            tx.commit();
            if(list.size()==1){
                return SUCCESS;
            }else {
                return ERROR;}
        }catch (Exception e){
            e.printStackTrace();
            HibernateUtil.getSessionFactory().close();
            return ERROR;
        }
    }

}
