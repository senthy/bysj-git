package zzs.bysj.entity;

import java.util.Date;

/**
 * 学生类
 *
 */

public class Teachers {
	private String tid;//教师编号	
	private String tname;//姓名
	private String tgender;//性别
	private String tcourse;//任课科目
	
	/**
	 *保留不带参数的构造方法
	 */
	public Teachers(){
		
	}
	/**
	 *保留带参数的构造方法
	 */
	public Teachers(String tid,String tname,String tgender,String tcourse){
		super();
		this.tid=tid;
		this.tname=tname;
		this.tgender=tgender;
		this.tcourse=tcourse;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTgender() {
		return tgender;
	}

	public void setTgender(String tgender) {
		this.tgender = tgender;
	}

	public String getTcourse() {
		return tcourse;
	}

	public void setTcourse(String tcourse) {
		this.tcourse = tcourse;
	}
	
}
