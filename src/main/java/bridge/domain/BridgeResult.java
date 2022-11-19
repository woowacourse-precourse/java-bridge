package bridge.domain;

import static bridge.service.BridgeMaker.UP_STRING;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BridgeResult {

	private final List<String> upBridge;
	private final List<String> downBridge;

	public BridgeResult() {
		upBridge = new ArrayList<>();
		downBridge = new ArrayList<>();
	}

	public void crossBridge(BridgeStatus bridgeStatus, String move) {
		boolean moveFlag = checkMove(move);
		if (moveFlag) {
			upBridge.add(bridgeStatus.getMessage());
			downBridge.add(" ");
			return;
		}
		downBridge.add(bridgeStatus.getMessage());
		upBridge.add(" ");
	}

	private boolean checkMove(String move) {
		return Objects.equals(move, UP_STRING);
	}

	@Override
	public String toString() {
		return upBridge.stream().collect(Collectors.joining(" | ", "[ ", " ]"))
			+ "\n"
			+ downBridge.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
	}
}
