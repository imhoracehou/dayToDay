package thread;

public class ThreadTest {
	public static void main(String[] args) throws Exception{
	}

	public static void test1() {
		Thread1 test1 = new Thread1("thread1");
		Thread1 test2 = new Thread1("thread2");
		test1.start();
		test2.start();
	}

	public static void test2() {
		// 更推荐使用实现Runnable接口
		ThreadRunnable1 runnable3 = new ThreadRunnable1("thread3");
		ThreadRunnable1 runnable4 = new ThreadRunnable1("thread4");
		Thread test3 = new Thread(runnable3);
		Thread test4 = new Thread(runnable4);
		test3.start();
		test4.start();
	}

	
}
