package bridge.constant;

public enum NumericConstant {
	MIN_BRIDGE_SIZE(3),
	MAX_BRIDGE_SIZE(20),
	DOWN_BRIDGE_NUMBER(0),
	UP_BRIDGE_NUMBER(1);

	private final int constValue;

	NumericConstant(int constValue) {
		this.constValue = constValue;
	}

	public int getConstValue() {
		return constValue;
	}
}
