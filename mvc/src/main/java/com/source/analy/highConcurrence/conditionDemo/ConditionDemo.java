package com.source.analy.highConcurrence.conditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition newCondition = reentrantLock.newCondition();
		new Thread(()->{
			try{
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName()+"获得锁");
				newCondition.await();
				System.out.println(Thread.currentThread().getName()+"被唤醒后继续执行");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				reentrantLock.unlock();
			}
		},"waitThread").start();
		new Thread(()->{
			try{
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName()+"获得锁");
				newCondition.signal();
				System.out.println("唤醒等待线程");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				reentrantLock.unlock();
			}
		},"notifyThread").start();
	}
}
