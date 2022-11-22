package bridge.util;

public interface Logger {
	static void error(String message) {
		System.out.printf("[ERROR] %s\n", message);
	}
}
