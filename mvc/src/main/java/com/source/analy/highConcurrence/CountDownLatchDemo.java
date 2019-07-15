package com.source.analy.highConcurrence;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		new Thread(()->{
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();
		}).start();
		new Thread(()->{
			countDownLatch.countDown();
		}).start();
		new Thread(()->{
			countDownLatch.countDown();
		}).start();
		countDownLatch.await();
		System.out.println("complete");
	}
}
