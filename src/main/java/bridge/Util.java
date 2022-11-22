package bridge;

import java.util.List;

public class Util {

	public static boolean valueEqualCheck(List<String> a, List<String> b, int idx) {
		return a.get(idx).equals(b.get(idx));
	}

	public static boolean isSameString(String str1, String str2) {
		return str1.equals(str2);
	}
}
