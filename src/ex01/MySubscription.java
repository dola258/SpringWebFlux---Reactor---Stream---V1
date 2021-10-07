package ex01;

import java.util.Iterator;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

// 구독 정보를 가진 클래스 - 내용이 적힌 잡지
public class MySubscription implements Subscription {
	
	Iterator<Integer> it;
	private Subscriber subscriber;
	
	public MySubscription(Iterable<Integer> its, Subscriber subscriber) {
		System.out.println(" - 구독 정보 만들어짐");
		this.it = its.iterator();
		this.subscriber = subscriber;
	}

	
	@Override
	public void request(long n) {
		System.out.println("3. 잡지" + n + "개씩 받을게!!"); // 백프레셔 - 조정을 해야함
		while(n-- > 0) {
			if(it.hasNext()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				subscriber.onNext(it.next());
			} else {
				subscriber.onComplete();
				break;
			}
		}
	}

	@Override
	public void cancel() {
		System.out.println("구독 취소");
	}
}
