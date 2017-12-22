package thread;

public class ThreadRunnable1 implements Runnable {
	private String tname;

	public ThreadRunnable1(String tname) {
		this.tname = tname;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tname + " run " + i);
		}
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
