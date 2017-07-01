package com.itheima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 这是一个c3p0连接池的工具类
 * 
 *  @author 长孙建坤 18092853734
 *  @version v1.0 2017年5月4日下午8:03:48
 */
public class C3P0Utils {
	/** c3p0 连接池对象 */
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/** 数据库连接对象 */
	private static Connection conn = null;
	
	/**
	 * 获取数据库连接
	 * @return 数据库连接
	 */
	public static Connection getConnection(){
		try {
			conn = dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭资源
	 * @param conn  数据库连接
	 * @param stmt  数据库语句预编译对象
	 * @param rs  数据库查询结果集
	 */
	public static void close(Connection conn , PreparedStatement stmt , ResultSet rs ){
		
		//关闭数据库连接
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		
		//关闭预编译对象
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		//关闭查询结果集
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	/**
	 * 关闭资源
	 * @param conn  数据库连接
	 * @param stmt  数据库语句预编译对象
	 */
	public static void close(Connection conn , PreparedStatement stmt ){
		C3P0Utils.close(conn, stmt, null);
	}
}
