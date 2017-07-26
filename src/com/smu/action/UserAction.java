package com.smu.action;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.model.Teacher;
import com.smu.util.UserInfo;
import com.smu.service.IUserService;
import com.alibaba.fastjson.*;
import org.apache.struts2.ServletActionContext;
import java.util.Collections;
import java.util.Comparator;
public class UserAction extends ActionSupport{
	private IUserService userService;
	private Teacher teacher;
	private String TId;
    private String result;
    private String TName;

	public String getTName() {
		return TName;
	}

	public void setTName(String TName) {
		this.TName = TName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTId() {
		return TId;
	}

	public void setTId(String TId) {
		this.TId = TId;
	}

	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String checkUser() throws Exception
	{
		Map session=(Map) ActionContext.getContext().getSession();
		Teacher user1 = new Teacher();
		user1 = userService.checkUser(teacher);
		if(user1 == null){
			return ERROR;
		}
		String role = user1.getRole();
		if(role.equals("guest"))
		{
			session.put("userName",user1.getTName());
			session.put("user",user1);
			session.put("id",user1.getTId());
			System.out.println(ServletActionContext.getRequest().getRemoteAddr());
			System.out.println(getIpAddr(ServletActionContext.getRequest()));
			return SUCCESS;
		}
		else if(role.equals("admin")){
			session.put("user",user1);
			return LOGIN;
		}
		else
		return ERROR;

	}
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	public String logOut() throws Exception
	{
		Map session=(Map) ActionContext.getContext().getSession();
		session.remove("user");
		session.remove("id");
		return SUCCESS;
	}
    public String getAllTeachers() throws Exception
	{
		List<Teacher> teachers = userService.getAllTeachers();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for(int i = 0;i<=teachers.size()-1;i++){
			if(teachers.get(i).getRole().equals("admin"))
				continue;
			UserInfo u = new UserInfo();
			u.setTeacherId(teachers.get(i).getTId());
			u.setTeacherName(teachers.get(i).getTName());
			userInfos.add(u);
		}
		Collections.sort(userInfos, new Comparator<UserInfo>(){

			/*
			 * int compare(Student o1, Student o2) 返回一个基本类型的整型，
			 * 返回负数表示：o1 小于o2，
			 * 返回0 表示：o1和o2相等，
			 * 返回正数表示：o1大于o2。
			 */
			public int compare(UserInfo o1, UserInfo o2) {

				//按照学生的年龄进行升序排列
				if(Integer.parseInt(o1.getTeacherId()) >Integer.parseInt(o2.getTeacherId())){
					return 1;
				}
				if(Integer.parseInt(o1.getTeacherId()) == Integer.parseInt(o2.getTeacherId())){
					return 0;
				}
				return -1;
			}
		});
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("userInfos", userInfos);
		return SUCCESS;
	}
	public String addOneTeacher() throws Exception{
		Map<String,String > map = new HashMap<String,String>();
		teacher.setRole("guest");
		if(userService.addOneTeacher(teacher)){
			map.put("result","ok");
		}
		result = JSON.toJSONString(map);
		return SUCCESS;
	}
	public String deleteOneTeacher() throws Exception{
		Map<String,String > map = new HashMap<String,String>();
		if(userService.deleteOneTeacher(TId)) {
			map.put("result","ok");
		}
		result = JSON.toJSONString(map);
		return SUCCESS;
	}
	public String checkTeacherId() throws Exception{
		Map<String,String > map = new HashMap<String,String>();
		if(userService.checkTeacherId(TId)){
			map.put("result","alreadyHad");
		}
		result = JSON.toJSONString(map);
		return SUCCESS;
	}
	public String updateOneTeacherName() throws Exception{
		Map<String,String > map = new HashMap<String,String>();
		if(userService.updateOneTeacherName(TId,TName)){
			map.put("result","ok");
		}
		result = JSON.toJSONString(map);
		return SUCCESS;
	}
}
