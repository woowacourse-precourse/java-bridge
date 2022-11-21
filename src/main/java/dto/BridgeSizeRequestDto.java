package dto;

public class BridgeSizeRequestDto {
	private final int bridgeSize;

	public BridgeSizeRequestDto(int bridgeSize) {
		this.bridgeSize = bridgeSize;
	}

	public int getBridgeSize() {
		return bridgeSize;
	}
}
