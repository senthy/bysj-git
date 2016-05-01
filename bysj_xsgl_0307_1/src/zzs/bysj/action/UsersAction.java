package zzs.bysj.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import zzs.bysj.entity.Users;
import zzs.bysj.service.UsersDAO;
import zzs.bysj.service.impl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户Action类
 * 实现modelDriven用模型驱动接收参数
 */
public class UsersAction extends SuperAction implements ModelDriven<Users>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	//用户登录动作
	public String login(){
		UsersDAO udao=new UsersDAOImpl();
		if(udao.usersLogin(user)){
			//在session中保存登录成功用户名,用session内置对象范围存取
			//界面中用EL表达式${sessionScope.loginUserName}
			session.setAttribute("loginUserName", user.getUsername());
			
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	//用户注销方法(skipvalidation跳过验证)
	@SkipValidation
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";//配置action
	}

	@Override
	public void validate(){
		// 验证表单：用户名不能为空(trim去掉前后空格)
		//1判断用户不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		//2判断密码不能为空且不为空时不能少于5位
		if(user.getPassword()==null||"".equals(user.getPassword().trim())){
			this.addFieldError("passwordNullError", "密码不能为空!");
		}else{
			if(user.getPassword()!=null&&user.getPassword().length()<5)
				this.addFieldError("passwordError", "用户密码不能少于5位！");
		}
	}

	public Users getModel() {
		return this.user;
	}

}
