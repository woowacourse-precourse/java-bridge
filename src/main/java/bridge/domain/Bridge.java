package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

	private List<String> bridge;

	public Bridge() {
		this.bridge = new ArrayList<>();
	}

	public void initBridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public boolean checkValidSpace(String userSpace, Integer currentSpace) {
		return bridge.get(currentSpace).equals(userSpace);
	}

}
