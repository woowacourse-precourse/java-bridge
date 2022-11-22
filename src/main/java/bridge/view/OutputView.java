package bridge.view;

import bridge.domain.result.BridgeResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	public static final String ENTER = System.lineSeparator();
	private static final String PRINT_GAME_START = "다리 건너기 게임을 시작합니다.";
	private static final String PRINT_SIZE_SELECT = ENTER + "다리의 길이를 입력해주세요.";


	private static final String MOVE_SELECT = ENTER + "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String GAME_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String SUCCESS = " O ";
	private static final String FAIL = " X ";
	private static final String BLANK = "   ";
	private static final String BRIDGE_RESULT_OPEN = "[";
	private static final String BRIDGE_RESULT_CLOSE = "]";
	private static final String BRIDGE_RESULT_MIDDLE = "|";

	public void printStartGame() {
		System.out.println(PRINT_GAME_START);
	}

	public void printSizeSelect() {
		System.out.println(PRINT_SIZE_SELECT);
	}

	public void printMoveSelect() {
		System.out.println(MOVE_SELECT);
	}

	public void printRetry() {
		System.out.println(GAME_RETRY);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String printMap(List<String> bridges, List<String> moves) {
		StringBuilder logUpLine = new StringBuilder(BRIDGE_RESULT_OPEN);
		StringBuilder logDownLine = new StringBuilder(BRIDGE_RESULT_OPEN);
		for (int index = 0; index < moves.size(); index++) {
			String bridgeColumn = bridges.get(index);
			String moveColumn = moves.get(index);
			if (index > 0) {
				logUpLine.append(BRIDGE_RESULT_MIDDLE);
				logDownLine.append(BRIDGE_RESULT_MIDDLE);
			}
			if (moveColumn.equals(bridgeColumn)) {
				if (moveColumn.equals("U")) {
					logUpLine.append(SUCCESS);
					logDownLine.append(BLANK);
				} else {
					logUpLine.append(BLANK);
					logDownLine.append(SUCCESS);
				}
			} else {
				if (moveColumn.equals("U")) {
					logUpLine.append(FAIL);
					logDownLine.append(BLANK);
				} else {
					logUpLine.append(BLANK);
					logDownLine.append(FAIL);
				}
			}
		}
		logUpLine.append(BRIDGE_RESULT_CLOSE);
		logDownLine.append(BRIDGE_RESULT_CLOSE);
		System.out.println(logUpLine + ENTER + logDownLine + ENTER);
		return logUpLine + ENTER + logDownLine;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeResult bridgeResult) {
		System.out.println("최종 게임 결과");
		System.out.println(bridgeResult.getMap() + ENTER);
		System.out.println("게임 성공 여부: " + bridgeResult.isSuccess());
		System.out.println("총 시도한 횟수: " + bridgeResult.getCountOfAttemps());
	}
}
