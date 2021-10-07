package ex01;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

// 구독자 = 일반인 = 소비자 = 컨슈머
public class MySubscriber implements Subscriber<Integer> {

	private Subscription subscription;
	private Integer size = 3;
	private Integer maxSize = 3;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("2. 구독 응답 완료(구독정보 - 데이터, 구독자)");
		this.subscription = subscription;
		subscription.request(size);
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("4. 잡지 받음" + item);
		size--;
		if(size == 0) {
			size = maxSize;
			subscription.request(size);
		}
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("잡지 전달하다가 교통사고 났어");
	}

	@Override
	public void onComplete() {
		System.out.println("더 이상 줄 잡지 없어");
	}
	
}
