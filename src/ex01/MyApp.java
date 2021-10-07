package ex01;

import java.util.Arrays;
import java.util.Iterator;		

public class MyApp {
	public static void main(String[] args) {
	   /*
	   Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	   System.out.println(its); System.out.println(its.iterator());
	   
	   Iterator<Integer> it = its.iterator();
	  
	  
	   while(it.hasNext()) { 
	   		System.out.println(it.next()); 
	   	}
	   */
		
		MyPublisher pub = new MyPublisher();
		MySubscriber sub = new MySubscriber();
		
		pub.subscribe(sub); // 구독 시작
		
	}
}
