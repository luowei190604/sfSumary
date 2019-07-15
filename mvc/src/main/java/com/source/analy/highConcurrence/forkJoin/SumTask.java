package com.source.analy.highConcurrence.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long>{

	private static final int THRESHOLD=20;
	
	private Long start;
	
	private Long end;
	
	public SumTask(Long start,Long end){
		this.start=start;
		this.end=end;
	}
	
	
	@Override
	protected Long compute() {
		Long sum=0L;
		if((end-start)<THRESHOLD){
			for(Long i=start;i<=end;i++){
				sum+=i;
			}
		}else{
			Long mid=(start+end)>>>1;
			SumTask left=new SumTask(start,mid);
			SumTask right=new SumTask(mid+1,end);
			left.fork();
			right.fork();
			sum=left.join()+right.join();
		}
		return sum;
	}
	public static void main(String[] args) {
//		Long mid=(long) ((1+100)>>>1);
//		System.out.println(mid);
//		System.out.println(3<<30);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		SumTask sumTask = new SumTask(1L,100L);
		ForkJoinTask<Long> task = forkJoinPool.submit(sumTask);
		try {
			Long result = task.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
