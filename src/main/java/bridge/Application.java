package bridge;

import bridge.domain.*;
import bridge.domain.view.InputView;
import bridge.domain.view.OutputView;

import static bridge.Constants.*;

public class Application {
	// todo 뺄거 생각하기
	static Bridge bridge;
	static PlayerBridge playerBridge = new PlayerBridge();
	static Map map = new Map();
	private static int count = 1;

	public static void main(String[] args) {
		int size = makeBridge();

		runGame(size);
	}

	private static void runGame(int size) {
		while (!map.success(map, size)) {
			System.out.println(MESSAGE_WANNA_MOVE);
			playerBridge.add(InputView.readMoving());
			new BridgeGame().move(map, bridge, playerBridge);
			OutputView.printMap(map);
			if (whenFail()) {
				return;
			}
		}
		OutputView.printResult(map, SUCCESS, count);
	}

	private static boolean whenFail() {
		if (!map.fail()) {
			return false;
		}
		System.out.println(MESSAGE_WANNA_RESTART);
		String command = InputView.readGameCommand();
		if (command.equals(RETRY)) {
			count = new BridgeGame().retry(map, playerBridge, count);
			return false;
		}
		OutputView.printResult(map, FAIL, count);
		return true;
	}

	private static int makeBridge() {
		System.out.println(MESSAGE_START);
		System.out.println(MESSAGE_BRIDGE_SIZE);
		int size = InputView.readBridgeSize();

		// todo 맘에 안듦
		bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));
		System.out.println();
		return size;
	}
}
