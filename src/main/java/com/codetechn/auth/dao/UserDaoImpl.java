package com.codetechn.auth.dao;

import com.codetechn.auth.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public User findByemail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query=currentSession.createQuery("from User where email=:uEmail",User.class);
        query.setParameter("uEmail",email);
        User user = null;
        try {
            user=query.getSingleResult();
        }catch (Exception e ){
            user =null;
        }

        return user;
    }
 /*   public User findByemail(String email) {
       List query = this.hibernateTemplate.findByNamedParam("from User where email=:email","email",email);
        User user = new User();


        try {
            user = (User) query.get(0);

        }catch (Exception e){
            user=null;
        }

 return user;
    }*/

   /* public void registerUser(User user) {
        this.hibernateTemplate.saveOrUpdate(user);

    }*/
    public void registerUser(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }
}
