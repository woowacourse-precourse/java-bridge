package bridge.repository;

import java.util.ArrayList;
import java.util.List;

public class BridgeRepository {

	private List<String> bridge;

	public BridgeRepository() {
		this.bridge = new ArrayList<>();
	}

	public void initBridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public boolean checkValidSpace(String userSpace, Integer currentSpace) {
		return bridge.get(currentSpace).equals(userSpace);
	}

}
