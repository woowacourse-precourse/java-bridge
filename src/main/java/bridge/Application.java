package bridge;

import bridge.domain.*;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;

import static bridge.Constants.*;

public class Application {
	static Bridge bridge;
	static PlayerBridge playerBridge = new PlayerBridge();
	static Map map = new Map();
	private static int count = 1;

	public static void main(String[] args) {

		int size = makeBridge();
		runGame(size);
	}

	private static int makeBridge() {
		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

		System.out.println(MESSAGE_START);
		System.out.println(MESSAGE_BRIDGE_SIZE);
		int size = InputView.readBridgeSize();

		bridge = new Bridge(bridgeMaker.makeBridge(size));
		System.out.println();
		return size;
	}

	private static void runGame(int size) {
		while (!BridgeGame.success(map, size)) {
			System.out.println(MESSAGE_WANNA_MOVE);
			playerBridge.add(InputView.readMoving());
			BridgeGame.move(map, bridge, playerBridge);
			OutputView.printMap(map);
			if (whenFail()) {
				return;
			}
		}
		OutputView.printResult(map, SUCCESS, count);
	}

	private static boolean whenFail() {
		if (!BridgeGame.fail(map)) {
			return false;
		}
		System.out.println(MESSAGE_WANNA_RESTART);
		if (InputView.readGameCommand().equals(RETRY)) {
			count = BridgeGame.retry(map, playerBridge, count);
			return false;
		}
		OutputView.printResult(map, FAIL, count);
		return true;
	}
}
