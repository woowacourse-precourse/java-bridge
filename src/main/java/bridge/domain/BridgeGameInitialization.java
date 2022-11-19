package bridge.domain;

import static bridge.view.ProgressMessage.*;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;

public class BridgeGameInitialization {
	BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private Bridge bridge;

	// 게임 시작 (다리, 사용자 둘다 초기화)
	public Bridge initBridge() {
		int bridgeSize = setBridgeSize();
		setBridge(bridgeSize);
		return bridge;
	}

	// 게임 재시작 (사용자만 초기화)

	// 다리길이 초기화
	private int setBridgeSize() {
		int bridgeSize = 0;
		try {
			bridgeSize = InputView.readBridgeSize();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			OutputView.printProgressMessage(INPUT_AGAIN);
			setBridgeSize();
		}
		return bridgeSize;
	}

	private void setBridge(int bridgeSize) {
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
	}

	// 사용자 정보 초기화
}
