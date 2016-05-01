package zzs.bysj.service;

import java.util.List;

import zzs.bysj.entity.Teachers;

/**
 * 学生业务逻辑接口
 */
public interface TeachersDAO {
	//1、查询所有学生资料
	public List<Teachers> queryAllTeachers();
//	//2、查询学生资料
//	public Teachers queryTeachersByTid(String tid);
//	//3、添加学生资料
//	public boolean addTeachers(Teachers t);
//	//4、修改学生资料
//	public boolean updateTeachers(Teachers t);
//	//5、删除学生资料
//	public boolean deleteTeachers(String tid);
}
