package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

	private List<String> bridge;
	private Integer bridgeSize;

	public Bridge() {
		this.bridge = new ArrayList<>();
	}

	public void initBridge(List<String> bridge, Integer bridgeSize) {
		this.bridgeSize = bridgeSize;
		this.bridge = bridge;
	}

	public boolean checkValidSpace(String userSpace, Integer currentIndex) {
		return bridge.get(currentIndex).equals(userSpace);
	}

	public boolean checkEndLocation(Integer currentLocation) {
		return bridgeSize == currentLocation;
	}

}
