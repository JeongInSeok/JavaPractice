
public class Ex7 {

	public static void main(String[] args) {
		YourThread yt1 = new YourThread("A작업", 1000000);
		YourThread yt2 = new YourThread("B작업", 100000);
		YourThread yt3 = new YourThread("C작업", 1000000);
		
		// Runnable 인터페이스 내에는 start() 메서드가 존재하지 않는다!
//		yt1.start();
		
		// 대신, Thread 클래스의 인스턴스를 생성하여
		// 파라미터로 Runnable 인터페이를 구현한 객체를 전달한 뒤
		// Thread 클래스의 start() 메서드를 호출하면 대신 멀티쓰레딩으로 처리해준다!
		Thread t1 = new Thread(yt1);
		Thread t2 = new Thread(yt2);
		Thread t3 = new Thread(yt3);
		// Thread 클래스 인스턴스의 start() 메서드 호출
		t1.start();
		t2.start();
		t3.start();
				
	}

}

class A {}

// 멀티쓰레딩 클래스 정의할 때, 이미 다른 클래스를 상속받은 경우 Thread 클래스 상속 불가
// => Thread 클래스 대신 Runnable 인터페이스를 구현하는 방법을 사용해야함
class YourThread extends A implements Runnable {
	String name;
	int count;
	
	public YourThread(String name, int count) {
		this.name = name;
		this.count = count;
	}

	// 멀티쓰레딩으로 처리할 코드들을 run() 메서드를 오버라이딩 하여 구현
	@Override
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(name + " : " + i);
		}
	} 
}