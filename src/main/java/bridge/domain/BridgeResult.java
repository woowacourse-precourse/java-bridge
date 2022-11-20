package bridge.domain;

import static bridge.service.BridgeMaker.UP_STRING;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BridgeResult {

	private static final String EMPTY = " ";

	private final List<String> upBridge;
	private final List<String> downBridge;

	public BridgeResult() {
		upBridge = new ArrayList<>();
		downBridge = new ArrayList<>();
	}

	public void crossOneBridge(BridgeStatus bridgeStatus, String move) {
		boolean isUp = checkMove(move);

		if (isUp) {
			addBridge(bridgeStatus.getMessage(), EMPTY);

			return;
		}
		addBridge(EMPTY, bridgeStatus.getMessage());
	}

	private void addBridge(String upBridge, String downBridge) {
		this.upBridge.add(upBridge);
		this.downBridge.add(downBridge);
	}

	private boolean checkMove(String move) {
		return Objects.equals(move, UP_STRING);
	}

	@Override
	public String toString() {
		return upBridge.stream().collect(Collectors.joining(" | ", "[ ", " ]\n"))
			+ downBridge.stream().collect(Collectors.joining(" | ", "[ ", " ]\n"));
	}
}
