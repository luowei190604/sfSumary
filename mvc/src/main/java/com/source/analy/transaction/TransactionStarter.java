package com.source.analy.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionStarter {
	
	public static void main(String[] args) {
		Connection connection =null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			connection = DriverManager.getConnection("jdbc:mysql://10.203.187.39:3306/cloud_biz?characterEncoding=UTF-8&useSSL=false", "cloudpri", "cloudpri_123456");
			connection.setAutoCommit(false);
			//预编译sql
			PreparedStatement prepareStatement = connection.prepareStatement("insert into combo_module(combo_id,module_id)values(1987,1988)");
			//执行
			prepareStatement.execute();
			//解析返回结果
			System.out.println(1/0);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
//biz.datasource.jdbc.driverClassName = com.mysql.jdbc.Driver
//biz.datasource.jdbc.type=com.alibaba.druid.pool.DruidDataSource
//biz.datasource.jdbc.url = jdbc:mysql://10.203.187.39:3306/cloud_biz?characterEncoding=UTF-8&useSSL=false
//biz.datasource.jdbc.username = cloudpri
//biz.datasource.jdbc.password = cloudpri_123456
