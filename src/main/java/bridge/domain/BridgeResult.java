package bridge.domain;

import static bridge.view.InputView.UP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.bytebuddy.build.ToStringPlugin.Enhance.Prefix;

public class BridgeResult {

	private static final String EMPTY = " ";
	private static final String DELIMITER = " | ";
	private static final String PREFIX = "[ ";
	private static final String SUFFIX = " ]\n";

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
		return Objects.equals(move, UP);
	}

	@Override
	public String toString() {
		return upBridge.stream().collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX))
			+ downBridge.stream().collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
	}
}
