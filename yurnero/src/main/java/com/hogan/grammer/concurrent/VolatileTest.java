package com.hogan.grammer.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VolatileTest {

	public static int a = 0;
	
	public volatile static int count = 0;
	 
    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
 
        count++;
    }

	public static void main(String[] args) {
		
	Map<String, String> map = new ConcurrentHashMap<String, String>();
		new Thread(new Runnable() {

			@Override
			public void run() {
//				while (true) {
//					System.out.println("a is:" + a);
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
					
					a=2;
					System.out.println("a is changed");
				}

		}).start();
		
		for(int j=0;j<100;j++){
			count =0;
			for (int i = 0; i < 1000; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                	VolatileTest.inc();
	                }
	            }).start();
	        }
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("运行结果:Counter.count=" + VolatileTest.count);
		}
	}
	
	

}
