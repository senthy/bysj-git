package zzs.bysj.service;

import java.util.List;

import zzs.bysj.entity.Students;

/**
 * 学生业务逻辑接口
 */
public interface StudentsDAO {
	//1、查询所有学生资料
	public List<Students> queryAllStudents();
	//2、查询学生资料
	public Students queryStudentsBySid(String sid);
	//3、添加学生资料
	public boolean addStudents(Students s);
	//4、修改学生资料
	public boolean updateStudents(Students s);
	//5、删除学生资料
	public boolean deleteStudents(String sid);
}
