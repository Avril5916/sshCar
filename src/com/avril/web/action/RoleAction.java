package com.avril.web.action;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.avril.domain.Menus;
import com.avril.domain.Roles;
import com.avril.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class RoleAction extends ActionSupport {

	@Autowired
	private RoleService rs;
	private List<Roles> roles;
	private Roles role;
	private List<Menus> menus;
	private String[] mlist;
	//查所有角色
	@Action(value="findRolesAll",results={@Result(name="addUser",location="/addUser.jsp")})
	public String findRolesAll(){
		this.roles = this.rs.findRolesAll();
		return "addUser";
	}

	
	//1.该预查找是为了把所有角色名查出来然后请求转发到findUser.jsp  @Action中的value是去掉.action的action名，
	//即jsp表单的action里要写preFindUserRole.action,就会发送到这个方法，result里 name是return的，location是指明对应的跳转页面
	//如果是重定向，需要再加  ,type="redirect"
	@Action(value="preFindUserRole",results={@Result(name="findUser",location="/findUser.jsp")})
	public String preFindUserRole(){
		this.roles = this.rs.findRolesAll();
		return "findUser";
	}

	@Action(value="findRole",results={@Result(name="showRole",location="/showRole.jsp")})
	public String findRole(){
		this.roles = this.rs.findRoleByName(role.getRolename());
		return "showRole";
	}
	
	//预新角色
	@Action(value="preAddNewRole",results={@Result(name="addNewRole",location="/addNewRole.jsp")})
	public String preAddNewRole(){
		this.menus = this.rs.findMenus();
		Collections.sort(menus);
		menus.remove(0);
		return "addNewRole";
	}
	
	//新角色
	@Action(value="addNewRole",results={@Result(name="ok",location="/ok.jsp")})
	public String addNewRole(){
		Set<Menus> mset= new HashSet<>();

		this.menus = this.rs.findMenus();
		for (String s : mlist) {
			for (Menus m : this.menus) {
				if(m.getMenuid()==Integer.parseInt(s)){
					mset.add(m);
				}
			}
		}
		this.role.setMenus(mset);
		this.rs.addRole(this.role);
		return "ok";
	}
	
	//删除角色(有错误)
	@Action(value="delRole",results={@Result(name="ok",location="/ok.jsp")})
	public String delRole(){
		this.rs.delRole(this.role);
		return "ok";
	}
	
	@Action(value="preUpdateRole",results={@Result(name="updateRole",location="/updateRole.jsp")})
	public String preUpdateRole(){
		this.menus = this.rs.findMenus();
		Collections.sort(menus);
		menus.remove(0);
		this.role = this.rs.findRoleByName(role.getRolename()).get(0);
		return "updateRole";
	}
	
	//编辑角色（有瑕疵）
	@Action(value="updateRole",results={@Result(name="ok",location="/ok.jsp")})
	public String updateRole(){
		Set<Menus> mset= new HashSet<>();
		this.menus = this.rs.findMenus();
		for (String s : mlist) {
			for (Menus m : this.menus) {
				if(m.getMenuid()==Integer.parseInt(s)){
					mset.add(m);
				}
			}
		}
		this.role.setMenus(mset);
		this.rs.updateRole(this.role);
		return "ok";
	}
	
	
	
	
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public List<Menus> getMenus() {
		return menus;
	}
	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}
	public String[] getMlist() {
		return mlist;
	}
	public void setMlist(String[] mlist) {
		this.mlist = mlist;
	}
}
