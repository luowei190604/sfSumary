package com.source.analy.highConcurrence.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PoolStarter {
	
	public static ExecutorService singlePool=Executors.newSingleThreadExecutor();
	
	public static ExecutorService fixedPool=Executors.newFixedThreadPool(5);
	
	public static ExecutorService cachePool=Executors.newCachedThreadPool();
	
	public static ScheduledExecutorService  schedulPool=Executors.newScheduledThreadPool(5);
	
	public static void main(String[] args) {
		//doSingle();
		//doFixed();
		//doCache();
		doScheduled();
	}
	
	public static void doSingle(){
		for(int i=0;i<10;i++){
			singlePool.execute(new Thread(()->{
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},"test"+i));
		}
		singlePool.shutdown();
	}
	
	public static void doFixed(){
		for(int i=0;i<10;i++){
			fixedPool.execute(new Thread(()->{
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},"thread"+i));
		}
		try {
			//Thread.sleep(10000);
			//fixedPool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void doCache(){
		for(int i=0;i<1000;i++){
			cachePool.execute(new Thread(()->{
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},"thread"+i));
		}
//		try {
//			Thread.currentThread().join();
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	public static void doScheduled(){
//		for(int i=0;i<10;i++){
//			schedulPool.execute(new Thread(()->{
//				try {
//					Thread.sleep(1000);
//					System.out.println(Thread.currentThread().getName());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}));
//		}
		for(int i=0;i<10;i++){
			schedulPool.scheduleAtFixedRate(new Thread(()->{
				System.out.println(Thread.currentThread().getName());
			}), 10,10, TimeUnit.SECONDS);
		}
	}
}
