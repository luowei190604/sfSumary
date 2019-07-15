package com.source.analy.highConcurrence.semaPhoreDemo;

import java.util.concurrent.Semaphore;
/**
 * semaphore 一般用来做限流，信号灯，基于AQS实现
 * @author 80003084
 *
 */
public class SemophoreDemo {
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		for(int i=0;i<10;i++){
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"通过限流策略");
					Thread.sleep(5000);
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
