package com.source.analy.highConcurrence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LockDemoStarter {
	
	volatile int a;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		ReentrantLock reentrantLock = new ReentrantLock();
		
		for(int i=0;i<3;i++){
			new ThreadDemo(reentrantLock,i+"").start();
		}
	}


	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}
	
}
class ThreadDemo extends Thread{
	private ReentrantLock reentrantLock;
	public ThreadDemo(ReentrantLock reentrantLock,String name){
		this.reentrantLock=reentrantLock;
	}
	@Override
	public void run() {
		try{
			reentrantLock.lock();
			Thread.sleep(10000);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			reentrantLock.unlock();
		}
	}
}
