package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
	private final List<String> bridge = new ArrayList<>();

	public void setBridge(List<String> makeBridge) {
		bridge.addAll(makeBridge);
	}

	public boolean contains(String userMove, int index) {
		return bridge.get(index).contains(userMove);
	}
}