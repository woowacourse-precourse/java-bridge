package bridge;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();


		// todo 다리 길이 입력
		int size = inputView.readBridgeSize();

		// 다리 생성
		Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));

		// todo 사용자 U, D 입력

		// todo move

	}
}
