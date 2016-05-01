package test.entity;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
	@Test
	public void testSchemaExport(){
		new SchemaExport(new Configuration().configure()).create(true,true);
//		//创建配置对象
//		Configuration config=new Configuration();
//		//创建服务注册对象
//		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
//		//创建sessionFactory
//		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
//		//获取session对象
//		Session session=sessionFactory.getCurrentSession();
//		//创建SchemaExport对象
//		SchemaExport export=new SchemaExport(config);
		//用Export()方法生成表结构
//		export.create(true, true);
	}
}
