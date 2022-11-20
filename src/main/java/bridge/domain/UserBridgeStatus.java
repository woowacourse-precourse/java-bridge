package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public enum UserBridgeStatus {

	UPPER_BRIDGE(),
	LOWER_BRIDGE();

	private final String PREFIX = "[ ";
	private final String SUFFIX = " ]";
	private final String PARTITION = " | ";
	private List<String> status;

	UserBridgeStatus() {
		this.status = new ArrayList<>();
	}

	public void updateStatus(String status) {
		this.status.add(status);
	}

	public String statusToString(Integer bridgeSize) {
		String statusToString = PREFIX;
		for (int i = 0; i < bridgeSize; i++) {
			statusToString += status.get(i);
			if (i != bridgeSize - 1) {
				statusToString += PARTITION;
			}
		}
		return statusToString + SUFFIX;
	}

	public void clearStatus() {
		this.status.clear();
	}

}
