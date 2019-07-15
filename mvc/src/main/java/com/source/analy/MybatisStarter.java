package com.source.analy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import com.source.analy.springJDBC.dao.UserMapper;
import com.source.analy.springJDBC.model.User;

public class MybatisStarter {
	
	public static void main(String[] args) throws IOException {
		//mybatisStart();
//		pringFile();
//		getVersion();
		//System.out.println(1/0);
//		Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
//		Set<Entry<Thread, StackTraceElement[]>> entrySet = allStackTraces.entrySet();
//		for(Entry<Thread, StackTraceElement[]> entry:entrySet){
//			Thread thread = entry.getKey();
//			StackTraceElement[] value = entry.getValue();
//			if(Thread.currentThread().equals(thread)){
//				continue;
//			}
//			System.out.println("\n线程:"+thread.getName()+"\n");
//			for(StackTraceElement stack:value){
//				System.out.println("\t"+stack+"\t");
//			}
		//}
		main1();
	}
	private static void mybatisStart() throws IOException {
		InputStream in = MybatisStarter.class.getClassLoader().getResourceAsStream("mybatis/mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(2);
		List<User> list = mapper.selectByIds(idList);
		System.out.println(list.size());
//		List<User> userList = new ArrayList<>();
//		User user1 = new User();
//		user1.setName("lisi");
//		
//		User user2 = new User();
//		user2.setName("zhangsan");
//		userList.add(user1);
//		userList.add(user2);
//		mapper.batchSaveUser(userList);
//		session.commit();
//		InputStream in = MybatisStarter.class.getResourceAsStream("/mybatis-config.xml");
//		InputStream in2 = MybatisStarter.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		System.out.println(Objects.isNull(in));
//		System.out.println(in2);
//		System.out.println(path);
//		InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
//		System.out.println(is);
	}
	public static void pringFile() {
		try{
			String str=StreamUtils.copyToString(new FileInputStream("D:/1.txt"), StandardCharsets.UTF_8);
			System.out.println(str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void getVersion(){
//		Package p = MybatisStarter.class.getPackage();
//		System.out.println(p.getImplementationVersion());
		System.out.println(ClassPathXmlApplicationContext.class.getPackage().getImplementationVersion());
	}
	
	public static void main1() throws IOException {
		ClassPathResource classPathResource = new ClassPathResource("mybatis-config.xml");
		//FileInputStream fis = new FileInputStream("/dubboDemo1Provider/src/main/resource/applicationContext-server.xml");
		InputStream inputStream = classPathResource.getInputStream();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
		String str="";
		while((str=bfr.readLine())!=null){
			System.out.println(str);
		}
	}
}
