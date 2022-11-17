package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {

	private final List<String> bridgeLetters;

	public Bridge() {
		bridgeLetters = new ArrayList<>();
	}

	public static Bridge createBridge() {
		return new Bridge();
	}

	public void putOneToUp(Integer number) {
		if (number == 1) {
			bridgeLetters.add("U");
		}
	}

	public void putZeroToDown(Integer number) {
		if (number == 0) {
			bridgeLetters.add("D");
		}
	}

	public List<String> getBridgeLetters() {
		return Collections.unmodifiableList(bridgeLetters);
	}
}
