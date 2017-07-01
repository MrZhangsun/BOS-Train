package com.itheima.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 这是一个数据库连接工具类
 * 
 *  @author 长孙建坤 18092853734
 *  @version v1.0 2017年5月4日下午4:44:46
 */
public class JDBCUtils {
	/** 数据库连接 */
	private static Connection conn = null;
	     
	/** 数库的连接地址 */
	private static String url = null;
	      
	/** 数库用户名 */
	private static String username = null;
	       
	/** 数登录密码 */
	private static String password = null;
	    
	/** 数库驱动名称 */
	private static String drivername = null;
	
	static{
		//加载配置文件
		InputStream resource = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
		Properties config = new Properties();
		
		//加载配置信息
		try {
			config.load(resource);
			drivername = config.getProperty("driver");
			url = config.getProperty("url");
			username = config.getProperty("username");
			password = config.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接
	 * @return 返回一个数据库连接对象
	 */
	public static Connection getConnection(){
		try {
			Class.forName(drivername);
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关闭资源
	 * @param conn 数据连接
	 * @param stmt 数据库语句执行对象
	 * @param rs 结果集对象
	 */
	public static void close(Connection conn, PreparedStatement stmt, ResultSet rs){
		try {
			//关闭连接
			if(conn != null){
				conn.close();
			}
			
			//关闭数据库语句执行对象
			if(stmt != null){
				stmt.close();
			}
			
			//关闭数据结果集
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭资源
	 * @param conn 关闭数据库连接
	 * @param stmt 关闭数据库语句执行对象
	 */
	public static void close(Connection conn, PreparedStatement stmt){
		JDBCUtils.close(conn, stmt, null);
	}
}
