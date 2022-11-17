package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
 * BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
 * BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */

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
		List<Integer> bridgeRandomNumbers = makeBridgeNumbers(size);
		modifyBridgeData(bridge, bridgeRandomNumbers);
		return bridge.getBridgeLetters();
	}

	private List<Integer> makeBridgeNumbers(int size) {
		BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
		List<Integer> bridgeNumbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			bridgeNumbers.add(randomNumberGenerator.generate());
		}
		return bridgeNumbers;
	}

	private void modifyBridgeData(Bridge bridge, List<Integer> bridgeNumbers) {
		for (Integer number : bridgeNumbers) {
			bridge.putOneToUp(number);
			bridge.putZeroToDown(number);
		}
	}
}
