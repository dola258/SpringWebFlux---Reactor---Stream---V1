package ex01;

import java.util.Arrays;	
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

// 출판사 = 신문사
public class MyPublisher implements Publisher<Integer> {

	// 출판할 데이터
	// 순차적으로 넣고 순차적으로 꺼낼 수만 있다
	Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
/*  
	Iterable<Integer> its = new ArrayList<>();
	ist.add(1);
	ist.add(2);
	...
	ist.add(10);
*/	
	
	public void subscribe(Subscriber<? super Integer> subscriber) {
		System.out.println("1. 구독 요청");
		subscriber.onSubscribe(new MySubscription(its, subscriber));
	}
	
}
