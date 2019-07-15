package com.source.analy;

import java.util.LinkedList;
/**
 * VM　param -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author 80003084
 *
 */
public class HeapOOM {
	static class OOMObject{
		
	}
	public static void main(String[] args) {
		LinkedList<OOMObject> linkedList = new LinkedList<>();
		for(;;){
			linkedList.add(new OOMObject());
		}
	}
}
