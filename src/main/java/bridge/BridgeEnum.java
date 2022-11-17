package bridge;

public enum BridgeEnum {
	UP(1,"U"),
	DOWN(0,"D");

	private int blockNumber;
	private String blockName;

	BridgeEnum(int i, String d) {
		this.blockName = d;
		this.blockNumber = i;
	}
}
