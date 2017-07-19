package com.avril.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author ASUS-PC
 *  功能表
 */
@Entity
public class Funs implements Serializable{
	@Id
	private Integer funid;//功能ID
 private String name;//功能名称
 private String uri;//功能路径
 @ManyToOne(fetch=FetchType.EAGER)
 @JoinColumn(name="menus_id")
 private Menus menu;
 
public Menus getMenu() {
	return menu;
}

public void setMenu(Menus menu) {
	this.menu = menu;
}

public Funs() {
	
}

public Funs(Integer funid, String name, String uri) {
	this.funid = funid;
	this.name = name;
	this.uri = uri;
}

public Integer getFunid() {
	return funid;
}

public void setFunid(Integer funid) {
	this.funid = funid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUri() {
	return uri;
}

public void setUri(String uri) {
	this.uri = uri;
}

@Override
public String toString() {
	return "Funs [funid=" + funid + ", name=" + name + ", uri=" + uri + "]";
}
 
 
}
