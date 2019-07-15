package com.source.analy.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.source.analy.springJDBC.model.User;

public class TestServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("init no parameter");
	}
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init with parameter");
//	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setId(110);
		user.setName("lisi");
		//JSONObject jsonObject = new JSONObject();
		
		ServletOutputStream os = resp.getOutputStream();
		os.write(user.toString().getBytes());
		os.close();
	}
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setId(12);
		user.setName("lisi");
//		String jsonString = JSON.toJSONString(user);
//		System.out.println(jsonString);
//		JSONObject parseObject = JSONObject.parseObject(jsonString, JSONObject.class);
//		System.out.println(parseObject);
		
//		FileOutputStream fos = new FileOutputStream("D://a.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(user);
//		oos.close();
		
		FileInputStream fis = new FileInputStream("D://a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User u = (User)ois.readObject();
		System.out.println(u);
		
		
		
	}
}
