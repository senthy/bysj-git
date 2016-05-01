package test.service.impl;

import junit.framework.Assert;

import org.junit.Test;

import zzs.bysj.entity.Users;
import zzs.bysj.service.UsersDAO;
import zzs.bysj.service.impl.UsersDAOImpl;

public class TestUsersDAOImpl {
	@Test
	public void testUsersLogin(){
		Users u=new Users(1,"admin","admin");
		UsersDAO udao=new UsersDAOImpl();//多态性
		//用断言判断是否
		Assert.assertEquals(true,udao.usersLogin(u));
	}
}
