package com.source.analy;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class IODemo {
	public static void main(String[] args) {
		try{
			StringBuilder dotString = new StringBuilder();
			dotString.append("hello");
			FileOutputStream fos=new FileOutputStream("D:/gr.txt");
			BufferedWriter bfw=new BufferedWriter(new OutputStreamWriter(fos));
			bfw.write(dotString.toString());
			bfw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
