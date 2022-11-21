package bridge;

import java.util.List;

public class Util {

	public static boolean valueEqualCheck(List<String> a, List<String> b, int idx) {
		return a.get(idx).equals(b.get(idx));
	}
}
