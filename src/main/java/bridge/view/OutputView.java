package bridge.view;

import bridge.domain.BridgeResult;
import bridge.service.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	private static final String MESSAGE_START = "다리 건너기 게임을 시작합니다.\n";
	private static final String MESSAGE_REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String MESSAGE_REQUEST_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String MESSAGE_REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String MESSAGE_RESULT = "최종 게임 결과";

	public void printStart() {
		System.out.println(MESSAGE_START);
	}

	public void printRequestBridgeSize() {
		System.out.println(MESSAGE_REQUEST_BRIDGE_SIZE);
	}

	public void printRequestMove() {
		System.out.println(MESSAGE_REQUEST_MOVE);
	}

	public void printRequestRetry() {
		System.out.println(MESSAGE_REQUEST_RETRY);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(BridgeResult bridgeResult) {
		System.out.println(bridgeResult);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeGame bridgeGame) {
		System.out.println(MESSAGE_RESULT);
		System.out.println(bridgeGame);
	}
}
