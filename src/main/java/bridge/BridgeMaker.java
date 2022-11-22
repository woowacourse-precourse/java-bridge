package bridge;

import bridge.utils.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
	private final int RANDOM_LOWER_INCLUSIVE = 0;
	private final int RANDOM_UPPER_INCLUSIVE = 1;
	private final String DOWN_DIRECTION = "D";
	private final String UP_DIRECTION = "U";
	private final String INVALID_RANDOM_NUMBER = "[ERROR] 랜덤 숫자의 범위는 0부터 1 사이의 숫자여야 합니다.";
	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	/**
	 * d
	 *
	 * @param size 다리의 길이
	 * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
	 */
	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		while (bridge.size() < size) {
			addBridgeDirection(bridge);
		}
		return bridge;
	}

	private void addBridgeDirection(List<String> bridge) {
		int bridgeRandomNumber = bridgeNumberGenerator.generate();
		validateBridgeNumber(bridgeRandomNumber);
		String bridgeDirection = convertBridgeNumber(bridgeRandomNumber);
		bridge.add(bridgeDirection);
	}

	private void validateBridgeNumber(int number) {
		if (number != RANDOM_LOWER_INCLUSIVE && number != RANDOM_UPPER_INCLUSIVE) {
			throw new IllegalArgumentException(INVALID_RANDOM_NUMBER);
		}
	}

	private String convertBridgeNumber(int bridgeRandomNumber) {
		if (bridgeRandomNumber == RANDOM_LOWER_INCLUSIVE) {
			return DOWN_DIRECTION;
		}
		return UP_DIRECTION;
	}
}
