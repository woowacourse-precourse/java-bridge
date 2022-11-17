package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	/**
	 * @param size 다리의 길이
	 * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
	 */
	public List<String> makeBridge(int size) {
		final List<String> bridge = new ArrayList<>();
		for (int bridgeSize = 0; bridgeSize < size; bridgeSize++) {
			int randomNumber = bridgeNumberGenerator.generate();
			validateRandomNumber(randomNumber);
			addBridgeState(bridge, randomNumber);
		}
		return bridge;
	}

	private void validateRandomNumber(int randomNumber) {
		if (randomNumber != BridgeState.DOWN.getRandomNumber() && randomNumber != BridgeState.UP.getRandomNumber()) {
			throw new IllegalStateException(BridgeState.DOWN.getBridgeStateErrorMessage());
		}
	}

	private void addBridgeState(List<String> bridge, int randomNumber) {
		if (randomNumber == BridgeState.DOWN.getRandomNumber()) {
			bridge.add(BridgeState.DOWN.getBridgeState());
			return;
		}
		if (randomNumber == BridgeState.UP.getRandomNumber()) {
			bridge.add(BridgeState.UP.getBridgeState());
			return;
		}
	}
}
