package bridge;

public class Compute {

	public static String computeUpBridge(String result, String bridge) {
		if ("O".equals(result) && "U".equals(bridge)) {
			return "O ";
		}
		if ("X".equals(result) && "D".equals(bridge)) {
			return "X ";
		}

		return "  ";
	}

	public static String computeDownBridge(String result, String bridge) {
		if ("O".equals(result) && "D".equals(bridge)) {
			return "O ";
		}
		if ("X".equals(result) && "U".equals(bridge)) {
			return "X ";
		}

		return "  ";
	}
}
