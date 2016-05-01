package zzs.bysj.action;

import java.util.List;

import zzs.bysj.entity.Teachers;
import zzs.bysj.service.TeachersDAO;
import zzs.bysj.service.impl.TeachersDAOImpl;


/**
 * 	学生Action类
 *
 */
public class TeachersAction extends SuperAction {

	//生成UID
	private static final long serialVersionUID = -6373156075861065365L;
	/**
	 * 	查询所有教师的Action
	 */
	public String query(){
		TeachersDAO tdao=new TeachersDAOImpl();
		List<Teachers> list=tdao.queryAllTeachers();
		//将查询到的集合放到session中
		if(list!=null&&list.size()>0){
			//判断集合不为空且大于0
			session.setAttribute("teachers_list", list);
		}
		return "query_success";
	}
//	/**
//	 * 删除学生资料的Action
//	 */
//	public String delete(){
//		StudentsDAO sdao=new StudentsDAOImpl();
//		String sid=request.getParameter("sid");
//		sdao.deleteStudents(sid);
//		return "delete_success";
//	}
//	/**
//	 * 添加学生资料的Action
//	 */
//	public String add() throws Exception{
//		Students s=new Students();
//		s.setSname((String) request.getAttribute("sname"));
//		s.setGender(request.getParameter("sgender"));
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		s.setBirthday(sdf.parse(request.getParameter("birthday")));
//		StudentsDAO sdao=new StudentsDAOImpl();
//		sdao.addStudents(s);
//		return "add_success";
//	}
//	/**
//	 * 修改学生资料的Action
//	 */
//	public String modify(){
//		//获得传递过来的学号
//		String sid=request.getParameter("sid");
//		StudentsDAO sdao=new StudentsDAOImpl();
//		Students s=sdao.queryStudentsBySid(sid);
//		//保存在会话中
//		session.setAttribute("modify_students", s);
//		return "modify_success";
//	}
//	/**
//	 * 保存修改后的学生资料的Action
//	 * @throws ParseException 
//	 */
//	public String save() throws Exception{
//		Students s=new Students();
//		s.setSid(request.getParameter("sid"));
//		s.setSname(request.getParameter("sname"));
//		s.setGender(request.getParameter("gender"));
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		s.setBirthday(sdf.parse(request.getParameter("birthday")));
//		s.setAddress(request.getParameter("address"));
//		StudentsDAO sdao=new StudentsDAOImpl();
//		sdao.updateStudents(s);
//		return "save_success";
//	}
	
}
