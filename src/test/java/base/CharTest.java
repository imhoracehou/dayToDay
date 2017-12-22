package base;

public class CharTest {
	public static void main(String[] args) {
		char[] chars = { '1', 'h', '3', 's', '2', };
		
		String charsToString = chars.toString();
		System.out.println(charsToString);
		
		StringBuffer sb = new StringBuffer();
		sb.append(chars);
		System.out.println(sb.toString());
	}
}
