package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.gameInput.PlayerMove;

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
		List<String> bridge = new ArrayList<>(size);
		List<Integer> randomNumbers = makeBridgeRandomNumber(size);

		setUOrD(bridge, randomNumbers);

		return bridge;
	}

	public static void setUOrD(List<String> bridge, List<Integer> randomNumbers) {

		for (Integer randomNumber : randomNumbers) {
			setU(bridge, randomNumber);
			setD(bridge, randomNumber);
		}
	}

	private static void setD(List<String> bridge, int randomNumber) {
		if (randomNumber == 0) {
			bridge.add(PlayerMove.DOWN.getDirection());
		}
	}

	private static void setU(List<String> bridge, int randomNumber) {
		if (randomNumber == 1) {
			bridge.add(PlayerMove.UP.getDirection());
		}
	}

	private List<Integer> makeBridgeRandomNumber(int size) {
		List<Integer> randomNumbers = new ArrayList<>(size);

		for (int index = 0; index < size; index++) {
			randomNumbers.add(bridgeNumberGenerator.generate());
		}

		return randomNumbers;
	}
}
