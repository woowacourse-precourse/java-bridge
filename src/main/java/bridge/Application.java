package bridge;

import static bridge.Constants.*;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		PlayerBridge playerBridge = new PlayerBridge();
		Map map = new Map();
		BridgeGame bridgeGame = new BridgeGame();

		System.out.println(MESSAGE_START);

		// todo 다리 길이 입력
		System.out.println(MESSAGE_BRIDGE_SIZE);
		int size = inputView.readBridgeSize();

		// 다리 생성
		Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));

		// todo 사용자 U, D 입력
		while (!map.success(map, size)) {
			System.out.println(MESSAGE_WANNA_MOVE);
			playerBridge.add(inputView.readMoving());

			// move
			bridgeGame.move(map, bridge, playerBridge);
			// 다리 출력
			outputView.printMap(map);

			if (map.fail()) {// 틀렸을 때
				System.out.println(MESSAGE_WANNA_RESTART);

				bridgeGame.retry();
			}

		}
	}
}
