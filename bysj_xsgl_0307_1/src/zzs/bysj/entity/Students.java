package zzs.bysj.entity;

import java.util.Date;

/**
 * 学生类
 *
 */

public class Students {
	private String sid;//学号	
	private String sname;//姓名
	private String gender;//性别
	private Date birthday;//出生日期
	
	/**
	 *保留不带参数的构造方法
	 */
	public Students(){
		
	}
	/**
	 *生成带参数的构造方法
	 */
	public Students(String sid, String sname, String gender, Date birthday,
			String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;//地址

	@Override
	public String toString() {
		return "Students [address=" + address + ", birthday=" + birthday
				+ ", gender=" + gender + ", sid=" + sid + ", sname=" + sname
				+ "]";
	}
}
