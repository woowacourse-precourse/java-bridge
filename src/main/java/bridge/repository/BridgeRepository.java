package bridge.repository;

import java.util.ArrayList;
import java.util.List;

public class BridgeRepository {

	private List<String> bridge;
	private Integer bridgeSize; // 이거 integer 로 받아도 크기 충분한지 체크해야함

	public BridgeRepository() {
		this.bridge = new ArrayList<>();
	}

	public void initBridge(List<String> bridge, Integer bridgeSize) {
		this.bridge = bridge;
		this.bridgeSize = bridgeSize;
	}

	public boolean checkValidSpace(String userSpace, Integer currentSpace) {
		return bridge.get(currentSpace).equals(userSpace);
	}

	public List<String> findBridge() {
		return bridge;
	}
}
