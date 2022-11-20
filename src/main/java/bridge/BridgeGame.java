package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private InputController input;
	private Bridge bridge;
	private OutputView output;
	private int gameTry = 1;

	public void init() {
		BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		input = new InputController();
		bridge = new Bridge(bridgeMaker.makeBridge(input.requestBridgeSize()));
		output = new OutputView();
	}

	public void play() {
		init();
		boolean status = true;
		int round = 0;
		output.printStart();
		status = move(round, status);
		output.printResult(status, gameTry); // status 를 매개변수로 받아 성고 실패 여부 판별 true : 성공, false : 실패
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move(int round, boolean status) {
		while (round < bridge.getSize() && status) {
			String userInput = input.requestMove();
			String movement = checkMovable(round, userInput);
			status = checkX(movement);
			output.printMap(round, bridge, userInput);
			round += checkO(movement);
			status = retry(status);
		}
		return status;
	}

	public int checkO(String movement) {
		if (movement.equals(" O ")) {
			return 1;
		}

		return 0;
	}

	public boolean checkX(String movement) {
		return movement.equals(" O ");
	}

	public String checkMovable(int round, String userInput) {
		if (userInput.equals("U")) {
			return bridge.getUpperBridge().get(round);
		}

		return bridge.getLowerBridge().get(round);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry(boolean status) {
		if (status) {
			return true;
		}

		gameTry++;
		return input.requestRetry().equals("R");
	}
}
