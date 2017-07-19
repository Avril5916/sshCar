package com.avril.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.avril.domain.Cars;
import com.avril.service.CarService;
import com.avril.util.Page;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
public class CarAction extends ActionSupport{

	@Autowired
	private CarService cs ;
	
	private Cars car ;
	private String carnumber;
	
	//图片上传的两个成员属性
	private String tpPathFileName;//文件名
	private File tpPath;//封装的文件对
	
	//分页成员变量
	private List<Cars> clist;
	private Page page;
	private Integer currentPage;
	
	
	public String getTpPathFileName() {
		return tpPathFileName;
	}

	public void setTpPathFileName(String tpPathFileName) {
		this.tpPathFileName = tpPathFileName;
	}

	public File getTpPath() {
		return tpPath;
	}

	public void setTpPath(File tpPath) {
		this.tpPath = tpPath;
	}

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	@Action(value="addCar",results={@Result(name="ok",location="/ok.jsp",type="redirect")})
	public String addCar() throws Exception{
		System.out.println(this.car.getDescription());
		cs.addCar(car);
		
	    //上传图片
		System.out.println(this.tpPathFileName);
		
		//读取文件，struts2将toPath封装成File对象，我们可以直接读取
		InputStream is=new FileInputStream(this.tpPath);
		//给文件去一个新名字，当天时间，变成long数字类型，拼接形如a.jpg后面的.jpg
		String newFileName=new Date().getTime()+this.tpPathFileName.substring(this.tpPathFileName.lastIndexOf("."));
		System.out.println(newFileName);
		ServletContext sc=ServletActionContext.getServletContext();
		String realPath=sc.getRealPath("images/pic/"+this.car.getCarnumber()+newFileName); 
		System.out.println(realPath);
		OutputStream os=new FileOutputStream(realPath);
		byte[] buff=new byte[1024];
		int flag;
		while ((flag=is.read(buff))!=-1){
			os.write(buff,0,flag);
			}
		os.flush();
		os.close();
		is.close();
		
		return "ok";
	}
	@Action(value="findCar",results={@Result(name="showcar",location="/showCar.jsp")})
	public String findCar(){
		//模糊查询
		clist = new ArrayList<>();
		//if(page==null)
			page = new Page();
		//传参数是带着jsp过来的存着查找用的信息的user,放到了ulist，再装到page里,查完返回的是查询结果list
		this.clist.add(car);
		page.setList(clist);
		page.setCurrentPage(this.currentPage);
		
		//分页查找结果用上面定义的page接受，这个类里的page和user都要有set get方法才会传到或者接受自jsp
		this.page = this.cs.findCar(page);
		
		return "showcar";
	}
	//-------删除
		@Action(value="delCar",results={@Result(name="ok",location="/ok.jsp")})
		public String delCar(){
			this.cs.delCar(this.carnumber);
			return "ok";
		}
		
		//预查询修改用户,编辑车的信息，通过主键将其查出，显示到updateCar.jsp页面
		@Action(value="preUpdateCar",results={@Result(name="updateCar",location="/updateCar.jsp")})
		public String preUpdateCar(){
			System.out.println(this.carnumber);
			this.car = this.cs.preUpdateCar(this.carnumber);
			return "updateCar";
		}
		@Action(value="updateCar",results={@Result(name="ok",location="/ok.jsp")})
		public String updateCar(){
			System.out.println(car);
			this.cs.updateCar(this.car);
			return "ok";
		}
	
	
	
	
	
	
	
	
	
	
	
	public List<Cars> getClist() {
		return clist;
	}

	public void setClist(List<Cars> clist) {
		this.clist = clist;
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

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	
	
}

