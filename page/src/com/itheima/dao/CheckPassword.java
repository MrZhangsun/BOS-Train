package com.itheima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户密码的校验
 * 
 * @author 长孙建坤 18092853734
 * @version 1.0 ，2017-05-08 18:21:42
 */
public class CheckPassword {
	/**
	 * 数据库密码的验证
	 * 
	 * @param user UserBean对象
	 * @return 数据库查询的结果集
	 * @throws SQLException 
	 */
	public boolean checkPassword(UserBean user) throws SQLException{
		//连接数据库
		Connection connection = C3P0Utils.getConnection();
		/*Connection connection = JDBCUtils.getConnection();*/
		String sql = "select * from account where userName = ? and passwords= ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, user.getUserName());
		statement.setObject(2, user.getPassword());
		ResultSet resultSet = statement.executeQuery();
		boolean result = resultSet.next();
		JDBCUtils.close(connection, statement,resultSet);
		return result;
	}
}
