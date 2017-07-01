package com.itheima.services;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.CheckPassword;
import com.itheima.dao.UserBean;

/**
 * 用户登录验证
 * 
 * @author 长孙建坤 18092853734
 * @version 1.0 ，2017-05-08 16:37:11
 */
public class LoginProving extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 获取用户登录信息并到数据库中进行验证
	 * 
	 * @param req 用户请求
	 * @param resp 服务器响应
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result;
		//利用name属性获取表单的值
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserBean user = new UserBean(username,password);
		
		//将数据传给dao层进行密码验证
		try {
			//对查询结果进行判断
			result = new CheckPassword().checkPassword(user);
			if(result){
				//修改编码集
				resp.setContentType("text/html;charset=UTF-8");
				resp.getWriter().println("<h1>Congratulations WELCOME YOUR LOGINING !</h1><br/>");
				resp.setStatus(302);
				resp.setHeader("Location", "/page/jump.html");
			}else {
				resp.getWriter().println("<h1>Fail to login !</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
