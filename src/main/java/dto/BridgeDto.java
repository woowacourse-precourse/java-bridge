package dto;

import java.util.List;

public class BridgeDto {
	private final List<String> bridge;
	public BridgeDto(List<String> bridge) {
		this.bridge = bridge;
	}

	public int getBridgeSize() {
		return bridge.size();
	}

	public List<String> getPartOfBridge(int index) {
		return bridge.subList(0, index+1);
	}

	public String getCellOfIndex(int index) {
		return bridge.get(index);
	}


}
