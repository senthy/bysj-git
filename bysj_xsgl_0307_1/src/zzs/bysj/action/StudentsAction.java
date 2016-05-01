package zzs.bysj.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import zzs.bysj.entity.Students;
import zzs.bysj.service.StudentsDAO;
import zzs.bysj.service.impl.StudentsDAOImpl;

/**
 * 	学生Action类
 *
 */
public class StudentsAction extends SuperAction {

	//生成UID
	private static final long serialVersionUID = -6373156075861065365L;
	/**
	 * 	查询所有学生的Action
	 */
	public String query(){
		StudentsDAO sdao=new StudentsDAOImpl();
		List<Students> list=sdao.queryAllStudents();
		//将查询到的集合放到session中
		if(list!=null&&list.size()>0){
			//判断集合不为空且大于0
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	/**
	 * 	通过学号查询学生资料的Action
	 */
	public String queryBySid(){
		String sid=request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s=sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);
		return "queryBySid_success";
	}
//	@Override
//	public void validate(){
//		// 验证表单：用户名不能为空(trim去掉前后空格)
//		//1判断用户不能为空
//		if("".equals(request.getParameter("sid").trim())){
//			this.addFieldError("sidError", "学号有误，请重新！");
//		}
//	}
	 
	/**
	 * 删除学生资料的Action
	 */
	public String delete(){
		StudentsDAO sdao=new StudentsDAOImpl();
		String sid=request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	/**
	 * 添加学生资料的Action
	 */
	public String add() throws Exception{
		Students s=new Students();
		s.setSname((String) request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}
	/**
	 * 修改学生资料的Action
	 */
	public String modify(){
		//获得传递过来的学号
		String sid=request.getParameter("sid");
		StudentsDAO sdao=new StudentsDAOImpl();
		Students s=sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	/**
	 * 保存修改后的学生资料的Action
	 * @throws ParseException 
	 */
	public String save() throws Exception{
		Students s=new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao=new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
	
}
