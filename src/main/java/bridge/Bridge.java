package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

	private final List<String> bridge = new ArrayList<>();

	public void matchBridge(List<String> input) {
		bridge.addAll(input);
	}
}
