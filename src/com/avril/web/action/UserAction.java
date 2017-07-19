package com.avril.web.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.avril.domain.Menus;
import com.avril.domain.Roles;
import com.avril.domain.Users;
import com.avril.service.RoleService;
import com.avril.service.UserService;
import com.avril.util.Page;
import com.opensymphony.xwork2.ActionSupport;

/*@Controller
@Scope("prototype")*/
@ParentPackage("default")
@InterceptorRefs(@InterceptorRef("loginIntercepter"))
//@Namespace("/")
public class UserAction extends ActionSupport{

	@Autowired
	private RoleService rs;
	private List<Roles> roles;
	@Autowired
	private UserService us;
	private Users user;
	private String username;
	private List<Users> ulist;
	private Page page;
	private Integer currentPage;//页码
	//3.jsp发过来的信息存在成员变量user里
	@Action(value="findUser",results={@Result(name="showUser",location="/showUser.jsp")})
	public String findUser(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//去userservice接口里创建新方法我就不截图了。。。
		//System.out.println(user);
		//System.out.println(this.currentPage);
		//if(ulist==null)//这两个判断用来帮着分页的，但分页失败了
			ulist = new ArrayList<>();
		//if(page==null)
			page = new Page();
		//传参数是带着jsp过来的存着查找用的信息的user,放到了ulist，再装到page里,查完返回的是查询结果list
		this.ulist.add(user);
		page.setList(ulist);
		page.setCurrentPage(this.currentPage);
		//分页查找结果用上面定义的page接受，这个类里的page和user都要有set get方法才会传到或者接受自jsp
		this.page = this.us.findUser(page);
		//session.setAttribute("page",page );
		return "showUser";
	}
	
	//-------删除
	@Action(value="delUser",results={@Result(name="ok",location="/ok.jsp")})
	public String delUser(){
		this.us.delUser(username);
		return "ok";
	}
	
	//预查询修改用户
	@Action(value="preUpdateUser",results={@Result(name="updateUser",location="/updateUser.jsp")})
	public String preUpdateUser(){
		this.user = this.us.preUpdateUser(this.username);
		this.roles = this.rs.findRolesAll();
		return "updateUser";
	}
	
	
	//登录
	@Action(value="login",results={@Result(name="login",location="/login.jsp",type="redirect"),
									@Result(name="index",location="/index.jsp"/*,type="redirect"*/)})
	public String login(){//登录方法
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		this.user = this.us.login(this.user);
		List<Menus> mlist = this.user.getRole().setToList();
		 Collections.sort(mlist);
		session.setAttribute("menus", mlist);
		session.setAttribute("user", user);
		if(this.user!=null){
			return "index";
		}else{
			
			return "login";
		}
	}
	
	@Action(value="addUser",results={@Result(name="login",location="/login.jsp",type="redirect"),
			@Result(name="ok",location="/ok.jsp",type="redirect")})
	public String addUser(){
		this.us.addUser(this.user);
		return "ok";
	}
	
	//编辑用户
	@Action(value="updateUser",results={@Result(name="ok",location="/ok.jsp",type="redirect")})
	public String updateUser(){
		this.us.updateUser(this.user);
		return "ok";
	}
	
	
	
	
	

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	public List<Users> getUlist() {
		return ulist;
	}
	public void setUlist(List<Users> ulist) {
		this.ulist = ulist;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
}
