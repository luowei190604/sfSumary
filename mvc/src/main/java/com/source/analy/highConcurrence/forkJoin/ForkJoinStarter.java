package com.source.analy.highConcurrence.forkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinStarter extends RecursiveTask<List<Boolean>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7242439030631505200L;

	private static final int THRESHOLD=1;
	
	private  int start;
	
	
	private List<String> totalList;
	
	public ForkJoinStarter(int start,List<String> totalList){
		this.start=start;
		this.totalList=totalList;
	}
	
	public static String createIp(){
		Random random = new Random(100);
		return String.valueOf(random.nextInt());
	}

	@Override
	protected List<Boolean> compute() {
		List<Boolean> list = new ArrayList<Boolean>();
		if(totalList.size()-start<=THRESHOLD){
			Random random = new Random(1);
			boolean bl=random.nextInt()==1?true:false;
			list.add(bl);
		}else{
			int mid=(start+totalList.size())>>>1;
			ForkJoinStarter leftTask = new ForkJoinStarter(start,totalList.subList(start, mid));
			ForkJoinStarter rightTask = new ForkJoinStarter(mid+1,totalList.subList(mid+1, totalList.size()));
			leftTask.fork();
			rightTask.fork();
			list.addAll(leftTask.join());
			list.addAll(rightTask.join());
		}
		return list;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		List<String> ipList = new ArrayList<>();
		for(int i=0;i<100;i++){
			ipList.add(createIp());
		}
		System.out.println(ipList.subList(0, 50).size());
//		ForkJoinStarter forkJoinStarter = new ForkJoinStarter(0, ipList);
//		ForkJoinTask<List<Boolean>> submit = forkJoinPool.submit(forkJoinStarter);
//		System.out.println(submit.get().size());
	}
}
