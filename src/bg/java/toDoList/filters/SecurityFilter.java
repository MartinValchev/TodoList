package bg.java.toDoList.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bg.java.toDoList.services.UserService;


@WebFilter(urlPatterns = "/jsp/*")
public class SecurityFilter implements Filter {
	// Take from database
	//private static final String serviceUsr = "admin";
	//private static final String servicePass = "1234";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

			HttpSession session = req.getSession(false);
			String uri = req.getRequestURI();
			
		if(session == null){
			res.sendRedirect("/TodoList/html/login.html");
		}else{
		String user= (String) session.getAttribute("user");
		if(user==null){
			res.sendRedirect("/TodoList/html/login.html");
		}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
}
