package bridge.domain;

public enum BridgeConfiguration {
	D(0), U(1);

	private final Integer code;

	BridgeConfiguration(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static String findCodeName(Integer code) {
		if (BridgeConfiguration.D.code.equals(code)) {
			return BridgeConfiguration.D.name();
		}
		return BridgeConfiguration.U.name();
	}
}
