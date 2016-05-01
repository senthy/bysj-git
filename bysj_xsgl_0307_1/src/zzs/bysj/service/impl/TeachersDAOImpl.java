package zzs.bysj.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import zzs.bysj.db.MyHibernateSessionFactory;
import zzs.bysj.entity.Teachers;
import zzs.bysj.service.TeachersDAO;


/**
 * 教师业务逻辑接口的实现类
 *
 */
public class TeachersDAOImpl implements TeachersDAO{

	//1、查询所有学生资料
	@SuppressWarnings("unchecked")
	public List<Teachers> queryAllTeachers(){
		Transaction tx=null;//生成事务对象
		List<Teachers> list=null;
		String hql="";
		
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Teachers";
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
//	//2、通过学号查询学生资料
//	public Teachers queryTeachersByTid(String tid){
//		Transaction tx=null;//生成事务对象
//		Teachers t=null;
//		try{
//			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
//			t=(Teachers) session.get(Teachers.class,tid);
//			tx.commit();
//			return t;
//		}catch(Exception e){
//			e.printStackTrace();
//			tx.commit();
//			return s;
//		}finally{
//			if(tx!=null){
//				tx=null;
//			}
//		}
//	}
//	//3、添加学生资料
//	public boolean addTeachers(Teachers t){
//		t.setTid(getNewTid());//设置学生学号
//		Transaction tx=null;//生成事务对象
//		try{
//			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
//			session.save(t);
//			tx.commit();
//			return true;
//		}catch(Exception ex){
//			ex.printStackTrace();
//			return false;
//		}finally{
//			if(tx!=null){
//				tx=null;
//			}
//		}
//		
//	}
//	//4、修改学生资料
//	public boolean updateTeachers(Teachers t){
//		Transaction tx=null;
//		try{
//			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
//			session.update(t);
//			tx.commit();
//			return true;
//		}catch(Exception ex){
//			ex.printStackTrace();
//			tx.commit();
//			return false;
//		}finally{
//			if(tx!=null){
//				tx=null;
//			}
//		}
//	}
//	//5、删除学生资料
//	public boolean deleteTeachers(String tid){
//		Transaction tx=null;
//		try{
//			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
//			Teachers t=(Teachers)session.get(Teachers.class, tid);
//			session.delete(t);
//			tx.commit();
//			return true;
//		}catch(Exception ex){
//			ex.printStackTrace();
//			tx.commit();
//			return false;
//		}finally{
//			if(tx!=null){
//				tx=null;
//			}
//		}
//	}
//	//生成学生学号
//	private String getNewTid(){
//		Transaction tx=null;
//		String hql="";
//		String tid=null;
//		try{
//			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
//			//获取当前学生最大编号
//			hql="select max(tid) from Teachers";
//			Query query=session.createQuery(hql);
//			sid=(String) query.uniqueResult();//
//			if(tid==null||"".equals(tid)){
//				tid="T001";
//			}else{
//				String temp=tid.substring(1);//取后两位
//				int i=Integer.parseInt(temp);//转成数字
//				i++;
//				temp=String.valueOf(i);
//				//int len=temp.length();//凑够两位 补零
//				for(int j=0;j<2;j++){
//					temp="0"+temp;
//				}
//				tid="T"+temp;
//			}
//			tx.commit();
//			return tid;
//		}catch(Exception ex){
//			ex.printStackTrace();
//			tx.commit();
//			return null;
//		}finally{
//			if(tx!=null){
//				tx=null;
//			}
//		}
//	}
//	
}
