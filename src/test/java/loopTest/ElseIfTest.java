package loopTest;

import java.util.HashMap;
import java.util.Map;



public class ElseIfTest {
	public static void main(String[] args) {
	}

	public static void loop100() {
		String name = "table";
		for (int i = 0; i < 1000000; i++) {
			if ("table".equals(name)) {
			}
			if ("c".equals(name)) {
			}
			if ("r".equals(name)) {
			}
			if ("f".equals(name)) {
			}
		}
	}

	public static void loop100Else() {
		String name = "table";
		for (int i = 0; i < 1000000; i++) {
			if ("table".equals(name)) {
			} else if ("c".equals(name)) {
			} else if ("r".equals(name)) {
			} else if ("f".equals(name)) {
			}
		}
	}
	
	public static void keySetTest(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", "ddd");
	}
}
