package test.service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import zzs.bysj.entity.Students;
import zzs.bysj.service.StudentsDAO;
import zzs.bysj.service.impl.StudentsDAOImpl;

/**
 * 测试学生业务逻辑实现接口
 *
 */
public class TestStudentsDAOImpl {
	@Test
	public void testQueryAllStudents(){//测试查询所有学生功能
		StudentsDAO sdao=new StudentsDAOImpl();
		List<Students> list=sdao.queryAllStudents();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	/**
	@Test
	public void testGetNewSid(){
		StudentsDAOImpl sdao=new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
	*/
	@Test
	public void testAddStudents(){
		Students s=new Students();
		s.setSname("阿什顿飞");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("asdf");
		StudentsDAO sdao=new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
	
}
