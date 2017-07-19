package com.avril.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author ASUS-PC
 *   角色表
 */
@Entity
public class Roles implements Serializable{
	@Id
	 @SequenceGenerator(name="aaa", sequenceName="seq_roles",allocationSize=1)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aaa")
	private Integer roleid;//角色ID
	private String rolename;//角色名称
  @OneToMany
  @JoinColumn(name="roleid")
  private Set<Users> users;//来自users的外键
  
  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name="roles_menus",joinColumns={@JoinColumn(name="roleid")},inverseJoinColumns={@JoinColumn(name="menuid")})
  private Set<Menus> menus;//多对多
  
  
  public Integer getRoleid() {
	  return roleid;
  }
  
  public List<Menus> setToList(){
	  List<Menus> mlist = new ArrayList<>();
	  for (Menus m : this.menus) {
		mlist.add(m);
	}
	  return mlist;
  }

public Set<Users> getUsers() {
	return users;
}
public void setUsers(Set<Users> users) {
	this.users = users;
}

public Set<Menus> getMenus() {
	return menus;
}
public void setMenus(Set<Menus> menus) {
	this.menus = menus;
}
public Roles() {
	
}
public Roles(Integer roleid, String rolename) {
	
	this.roleid = roleid;
	this.rolename = rolename;
}
public void setRoleid(Integer roleid) {
	this.roleid = roleid;
}
public String getRolename() {
	return rolename;
}
public void setRolename(String rolename) {
	this.rolename = rolename;
}
@Override
public String toString() {
	return "Roles [roleid=" + roleid + ", rolename=" + rolename + "]";
}
  
}
