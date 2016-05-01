package zzs.bysj.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *自定义会话工厂工具类，用于生成会话工厂
 *体现单例设计模式
 */
public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;//工厂会话属性
	private MyHibernateSessionFactory(){
		//构造方法私有化，保证单例模式
	}
	//公有的静态方法，用于获取会话工厂对象
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration config=new Configuration();//获取配置对象
			//Exception in thread "main" org.hibernate.HibernateException: Access to DialectResolutionInfo cannot be null when 'hibernate.dialect' not set
			//Hibernate4版本中调用buildsessionfactory()前要config.configure()
			config.configure();
			ServiceRegistry serviceRegistry=new  StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory=config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	}
}
