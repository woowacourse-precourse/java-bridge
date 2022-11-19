package bridge.service;

import bridge.util.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

	private final static int UP_NUMBER = 1;
	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	/**
	 * @param size 다리의 길이
	 * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
	 */
	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		validateRange(size);
		for (int bridgeNumber = 0; bridgeNumber < size; bridgeNumber++) {
			bridge.add(isUpAndDown(bridgeNumberGenerator.generate()));
		}
		return bridge;
	}

	private String isUpAndDown(int bridgeNumber) {
		if (bridgeNumber == UP_NUMBER) {
			return "D";
		}
		return "U";
	}

	private void validateRange(int size) {
		if (size < 3 || 20 < size) {
			Logger.error("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
			throw new IllegalArgumentException();
		}
	}
}
