package bridge;

import java.util.List;

import bridge.domain.Bridge;

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
		Bridge bridge = Bridge.createBridge();
		makeBridgeNumbers(size, bridge);
		return bridge.getBridgeLetters();
	}

	private void makeBridgeNumbers(int size, Bridge bridge) {
		for (int i = 0; i < size; i++) {
			Integer RandomNumber = bridgeNumberGenerator.generate();
			modifyBridgeData(bridge, RandomNumber);
		}
	}

	private static void modifyBridgeData(Bridge bridge, Integer number) {
		bridge.putOneToUp(number);
		bridge.putZeroToDown(number);
	}
}
