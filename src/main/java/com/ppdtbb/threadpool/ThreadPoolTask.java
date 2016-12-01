package com.ppdtbb.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTask {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("添加");
		list.add("修改");
		list.add("删除");
		list.add("查询");
		
		executeThreadPool(list);
	}
	
	public static void executeThreadPool(List<String> list) {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<list.size();i++) {
			ThreadService run = new ThreadService(new Integer(i).longValue(), list.get(i));
			pool.execute(run);
		}
		
		pool.shutdown();
	}
	
	public static class ThreadService implements Runnable {
		
		private Long id;
		private String name;
		
		public void run() {
			System.out.println("调用业务方法：id: " + id + ",name:" + name);
		}
		
		public ThreadService(Long id, String name) {
			this.id = id;
			this.name = name;
		}
		
	}

}
