package zzs.bysj.service.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import zzs.bysj.db.MyHibernateSessionFactory;
import zzs.bysj.entity.Users;
import zzs.bysj.service.UsersDAO;

public class UsersDAOImpl implements UsersDAO {
	@SuppressWarnings("unchecked")
	public boolean usersLogin(Users u){
		//事务对象
		Transaction tx=null;
		String hql="";
		
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			//开启事务
			tx=session.beginTransaction();
			hql="from Users where username=? and password=?";
			//创建一个Query对象，用session会话创建查询
			Query query=session.createQuery(hql);
			//传参
			query.setParameter(0,u.getUsername());
			query.setParameter(1,u.getPassword());
			//查询，返回结果集，用List接收
			List list=query.list();
			//提交事务
			tx.commit();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			//判断并关闭事务
			if(tx!=null){
				//tx.commit();//提交事务
				tx=null;
			}
		}
	}
}
