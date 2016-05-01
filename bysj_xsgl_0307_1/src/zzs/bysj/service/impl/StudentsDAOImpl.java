package zzs.bysj.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import zzs.bysj.db.MyHibernateSessionFactory;
import zzs.bysj.entity.Students;
import zzs.bysj.service.StudentsDAO;

/**
 * 学生业务逻辑接口的实现类
 *
 */
public class StudentsDAOImpl implements StudentsDAO{

	//1、查询所有学生资料
	@SuppressWarnings("unchecked")
	public List<Students> queryAllStudents(){
		Transaction tx=null;//生成事务对象
		List<Students> list=null;
		String hql="";
		
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return list;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	//2、通过学号查询学生资料
	public Students queryStudentsBySid(String sid){
		Transaction tx=null;//生成事务对象
		Students s=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			s=(Students) session.get(Students.class,sid);
			tx.commit();
			return s;
		}catch(Exception e){
			e.printStackTrace();
			tx.commit();
			return s;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	//3、添加学生资料
	public boolean addStudents(Students s){
		s.setSid(getNewSid());//设置学生学号
		Transaction tx=null;//生成事务对象
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
		
	}
	//4、修改学生资料
	public boolean updateStudents(Students s){
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	//5、删除学生资料
	public boolean deleteStudents(String sid){
		Transaction tx=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students s=(Students)session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
	//生成学生学号
	private String getNewSid(){
		Transaction tx=null;
		String hql="";
		String sid=null;
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//获取当前学生最大编号
			hql="select max(sid) from Students";
			Query query=session.createQuery(hql);
			sid=(String) query.uniqueResult();//
			
			String temp=sid.substring(5);//取后两位
			int i=Integer.parseInt(temp);//转成数字
			i++;
//			temp=String.valueOf(i);
//			//int len=temp.length();//凑够两位 补零
//			for(int j=0;j<1;j++){
//				temp="0"+temp;
//			}
			sid="13231"+i;
			
			tx.commit();
			return sid;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return null;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}
		
}
