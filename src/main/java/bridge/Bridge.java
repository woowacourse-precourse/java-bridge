package bridge;

import static bridge.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {

	private final List<String> bridgeLetters;

	public Bridge(List<String> bridgeLetters) {
		this.bridgeLetters = bridgeLetters;
	}

	public static Bridge createBridge() {
		return new Bridge(new ArrayList<>());
	}

	public void putOneToUp(Integer number) {
		if (isOne(number)) {
			bridgeLetters.add(UP);
		}
	}

	private static boolean isOne(Integer number) {
		return number == 1;
	}

	public void putZeroToDown(Integer number) {
		if (isZero(number)) {
			bridgeLetters.add(DOWN);
		}
	}

	private static boolean isZero(Integer number) {
		return number == 0;
	}

	public List<String> getBridgeLetters() {
		return Collections.unmodifiableList(bridgeLetters);
	}

	public boolean isEquals(String userSelectedCell, int index) {
		return userSelectedCell.equals(bridgeLetters.get(index));
	}

	public String findLetter(int phase) {
		return bridgeLetters.get(phase);
	}
}
