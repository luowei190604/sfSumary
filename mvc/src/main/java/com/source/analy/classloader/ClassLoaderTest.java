package com.source.analy.classloader;

public class ClassLoaderTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.source.analy.circleDependceModel.TestA");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
