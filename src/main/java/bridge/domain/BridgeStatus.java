package bridge.domain;

import bridge.Constants;

public enum BridgeStatus {
	UP(Constants.UP, 1),
	DOWN(Constants.DOWN, 0);

	private final String statusString;
	private final int statusInt;

	BridgeStatus(String bridgeValue1,int bridgeValue2){
		this.statusString = bridgeValue1;
		this.statusInt = bridgeValue2;
	}

	public String getBridgeString() {
		return statusString;
	}

	public int getBridgeInt() {
		return statusInt;
	}

	public static String findMate(int number){
		for (BridgeStatus status : BridgeStatus.values()){
			if (status.statusInt == number)
				return status.statusString;
		}
		return null;
	}
}
