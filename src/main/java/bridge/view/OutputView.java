package bridge.view;

import bridge.Constants;
import bridge.domain.GameRecord;
import bridge.service.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	public void printStart() {
		System.out.println(Constants.START_MESSAGE);
		printNewLine();
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(GameRecord gameRecord) {
		System.out.println(
			logToString(gameRecord.getUpLog()) + "\n" + logToString(gameRecord.getDownLog()));
		printNewLine();
	}

	private String logToString(List<String> log) {
		String PREFIX = "[ ";
		String DELIMITER = " | ";
		String SUFFIX = " ]";
		return PREFIX + String.join(DELIMITER, log) + SUFFIX;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeGame bridgeGame) {
		System.out.println(Constants.OUTPUT_GAME_RESULT);
		printMap(bridgeGame.getGameRecord());
		String gameStatus = bridgeGame.checkSituation().getStatus();
		System.out.printf(Constants.OUTPUT_SUCCESS_FAIL, gameStatus);
		System.out.printf(Constants.OUTPUT_GAME_ATTEMPTS,
			bridgeGame.getGameRecord().getTryAttempts());
	}

	public void printNewLine() {
		System.out.println();
	}
}
