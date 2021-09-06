
public class Ex6 {

	public static void main(String[] args) {
		/*
		 * 쓰레드(Thread)
		 * - 하나의 프로세스 내에서 자원을 공유하는 최소 실행단위
		 * - 두 개 이상의 쓰레드가 동작하는 것을 멀티쓰레딩(Multi Threading) 이라고 함
		 * - 멀티 쓰레딩 구현 방법
		 *   1) Thread 클래스를 상속받아 구현
		 *   2) Runnable 인터페이스를 상속받아 구현
		 * - 서브클래스에서 run() 메서드를 오버라이딩하여 
		 *   멀티쓰레딩으로 처리할 코드를 기술하고, 
		 *   Thread 클래스의 start() 메서드를 호출하여 멀티쓰레딩을 수행   
		 */
//		NoThread nt1 = new NoThread("A작업", 1000000);
//		NoThread nt2 = new NoThread("B작업", 100000);
//		NoThread nt3 = new NoThread("C작업", 1000000);
//		
//		// 단일 쓰레드(Single Thread) 방식이므로
//		nt1.run(); // A작업 100만번 처리가 끝나면
//		nt2.run(); // B작업이 실행되고, B작업 10만번 처리가 끝나면
//		nt3.run(); // C작업이 실행됨
		
		// -----------------------------------------------------
		
		MyThread mt1 = new MyThread("A작업", 1000000);
		MyThread mt2 = new MyThread("B작업", 100000);
		MyThread mt3 = new MyThread("C작업", 1000000);
		
		// 오버라이딩 한 run() 메서드를 호출하면 멀티쓰레딩이 되지 않는다!
		// => run() 메서드는 JVM 에 의해 별도로 호출되어야 하는 메서드
//		mt1.run();
//		mt2.run();
//		mt3.run();

		// 반드시 메서드 호출은 start() 메서드를 호출해야한다!
		mt1.start();
		mt2.start();
		mt3.start();
		
	}

}

class MyThread extends Thread {// 멀티쓰레딩 구현을 위해 Thread 클래스를 상속
	String name;
	int count;
	
	public MyThread(String name, int count) {
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

class NoThread {
	String name;
	int count;
	
	public NoThread(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(name + " : " + i);
		}
	}
	
}








