package thread;

public class Thread1 extends Thread {
	private String tname;

	public Thread1(String tname) {
		super();
		this.tname = tname;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tname+" run " + i);
		}
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
