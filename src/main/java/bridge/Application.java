package bridge;

import static bridge.Constants.*;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();

		System.out.println(START);

		// todo 다리 길이 입력
		System.out.println(WRITE_BRIDGE_SIZE);
		int size = inputView.readBridgeSize();

		// 다리 생성
		Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));

		// todo 사용자 U, D 입력
		System.out.println(WRITE_WANNA_MOVE);
		String want = inputView.readMoving();

		// todo move

	}
}
