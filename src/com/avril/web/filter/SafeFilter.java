package com.avril.web.filter;
/**
 * 权限过滤
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avril.domain.Funs;
import com.avril.domain.Menus;
import com.avril.domain.Users;

public class SafeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		String uri = request.getRequestURI();
		//如果用户正在登录我们需要放行
		if(uri.indexOf("login") != -1 || uri.indexOf("norole") != -1 || uri.indexOf("index") != -1){
			arg2.doFilter(arg0, arg1);
		}else{
			//访问的资源并不是登录资源
			
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("user");
			
			if(user==null){
				System.out.println("1");
				((HttpServletResponse)arg1).sendRedirect("norole.jsp");
			}else{
				
				Set<Menus> mset = user.getRole().getMenus();
				List<Funs> list = new ArrayList<>();
				for (Menus m : mset) {
					for (Funs f : m.getFuns()) {
						list.add(f);
					}
				}
				
				//uri的匹配
				boolean flag = false;
				for(Funs fun:list){
					//System.out.println(uri);
					//System.out.println(fun.getUri());
					//System.out.println(uri.indexOf(fun.getUri()));
					if(uri.indexOf(fun.getUri()) != -1){
						//System.out.println(fun.getUri());
						flag =true;
						break;
					}
				}
				if(flag){
					arg2.doFilter(arg0, arg1);
				}else{
					((HttpServletResponse)arg1).sendRedirect("norole.jsp");
				}
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
