package bridge.view;

import static bridge.message.MessageConstants.*;
import static bridge.message.OutputMessageConstants.*;

import java.util.List;

import bridge.domain.ResultMessageStatus;
import bridge.domain.ResultStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(List<ResultMessageStatus> bridgeStatuses) {
		String upFloorResultMessage = makeUpFloorMessage(bridgeStatuses);
		String downFloorResultMessage = makeDownFloorMessage(bridgeStatuses);

		System.out.println(upFloorResultMessage);
		System.out.println(downFloorResultMessage + "\n");
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(List<ResultMessageStatus> resultMessageStatuses, ResultStatus resultStatus, int tryCount) {
		System.out.print(GAME_RESULT_TITLE_MESSAGE);
		printMap(resultMessageStatuses);
		System.out.printf(GAME_RESULT_MESSAGE_FORMAT, resultStatus.getResultStatusMessage());
		System.out.printf(TOTAL_PLAY_COUNT_MESSAGE_FORMAT, tryCount);
	}

	public void printStartMessage() {
		System.out.print(START_MESSAGE);
	}

	public void printErrorMessage(IllegalArgumentException exception) {
		System.out.println(exception.getMessage());
	}

	public void printEndl() {
		System.out.println();
	}

	private String makeUpFloorMessage(List<ResultMessageStatus> bridgeStatuses) {
		StringBuilder result = new StringBuilder();
		result.append(BRIDGE_START_SYMBOL);
		for (ResultMessageStatus bridgeStatus : bridgeStatuses) {
			result.append(" ").append(bridgeStatus.getUpFloor()).append(" ").append(BRIDGE_MIDDLE_SYMBOL);
		}
		result.setLength(result.length() - 1);
		result.append(BRIDGE_END_SYMBOL);
		return result.toString();
	}

	private String makeDownFloorMessage(List<ResultMessageStatus> bridgeStatuses) {
		StringBuilder result = new StringBuilder();
		result.append(BRIDGE_START_SYMBOL);
		for (ResultMessageStatus bridgeStatus : bridgeStatuses) {
			result.append(" ").append(bridgeStatus.getDownFloor()).append(" ").append(BRIDGE_MIDDLE_SYMBOL);
		}
		result.setLength(result.length() - 1);
		result.append(BRIDGE_END_SYMBOL);
		return result.toString();
	}
}
