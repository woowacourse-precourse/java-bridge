package bridge.view;

import bridge.dto.GameResultDto;
import bridge.dto.MoveCommandDto;
import bridge.utils.CommandChecker;
import bridge.utils.MoveChecker;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private List<MoveCommandDto> moveHistory;
	private GameResultDto gameResult;

	public OutputView() {
		moveHistory = new ArrayList<>();
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap() {
		StringBuilder completeMap = buildMap();
		System.out.println(completeMap);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResultMessage() {
		System.out.println(OutputMessages.FINAL_RESULT);
		printMap();
		String result = String.valueOf(printSuccessOrFail()) + printTotalTry();
		System.out.println(result);
	}

	public void receiveMoveCommandResult(MoveCommandDto moveCommandDto) {
		moveHistory.add(moveCommandDto);
	}

	public void receiveGameResult(GameResultDto gameResultDto) {
		gameResult = gameResultDto;
	}

	public void checkResetOutput(String gameCommand) {
		if (CommandChecker.isEqualToRetry(gameCommand)) {
			resetOutputView();
		}
	}

	@Override public String toString() {
		return buildMap().toString() + printSuccessOrFail() + printTotalTry();
	}

	private StringBuilder buildMap() {
		StringBuilder upperMap = new StringBuilder();
		StringBuilder lowerMap = new StringBuilder();

		buildStartSign(upperMap, lowerMap);
		buildProgression(upperMap, lowerMap);
		buildEndSign(upperMap, lowerMap);

		return mergeUpperAndLowerMap(upperMap, lowerMap);
	}

	private void buildStartSign(StringBuilder upperMap, StringBuilder lowerMap) {
		upperMap.append(MapComponent.START_BRIDGE_BOARDER);
		lowerMap.append(MapComponent.START_BRIDGE_BOARDER);
	}

	private void buildProgression(StringBuilder upperMap, StringBuilder lowerMap) {
		int size = moveHistory.size();

		for (int index = 0; index < size; index++) {
			upperMap.append(buildUpperProgression(index));
			lowerMap.append(buildLowerProgression(index));
			appendSpaceDivider(upperMap, lowerMap, index);
		}
	}

	private void buildEndSign(StringBuilder upperMap, StringBuilder lowerMap) {
		upperMap.append(MapComponent.END_BRIDGE_BOARDER);
		lowerMap.append(MapComponent.END_BRIDGE_BOARDER);
	}

	private StringBuilder mergeUpperAndLowerMap(StringBuilder upperMap, StringBuilder lowerMap) {
		StringBuilder completeMap = new StringBuilder();
		return completeMap.append(upperMap).append("\n").append(lowerMap).append("\n");
	}

	private String buildUpperProgression(int index) {
		MoveCommandDto move = moveHistory.get(index);
		String moveCommand = move.getMoveCommand();
		boolean moveFlag = move.isAbleToMove();
		return selectUpMove(moveCommand, moveFlag);
	}

	private String buildLowerProgression(int index) {
		MoveCommandDto move = moveHistory.get(index);
		String moveCommand = move.getMoveCommand();
		boolean moveFlag = move.isAbleToMove();
		return selectDownMove(moveCommand, moveFlag);
	}

	private String selectUpMove(String moveCommand, boolean moveFlag) {
		if (isMoveToUp(moveCommand, moveFlag)) {
			return MapComponent.ABLE_TO_MOVE;
		} else if (MoveChecker.isEqualToUp(moveCommand)) {
			return MapComponent.UNABLE_TO_MOVE;
		}
		return MapComponent.NO_SELECT_MOVE;
	}

	private boolean isMoveToUp(String moveCommand, boolean moveFlag) {
		return moveCommand.equals("U") && moveFlag;
	}

	private String selectDownMove(String moveCommand, boolean moveFlag) {
		if (isMoveToDown(moveCommand, moveFlag)) {
			return MapComponent.ABLE_TO_MOVE;
		} else if (MoveChecker.isEqualToDown(moveCommand)) {
			return MapComponent.UNABLE_TO_MOVE;
		}
		return MapComponent.NO_SELECT_MOVE;
	}

	private boolean isMoveToDown(String moveCommand, boolean moveFlag) {
		return MoveChecker.isEqualToDown(moveCommand) && moveFlag;
	}

	private void appendSpaceDivider(StringBuilder upperMap, StringBuilder lowerMap, int index) {
		int limit = moveHistory.size() - 1;

		if (index != limit) {
			upperMap.append(MapComponent.SPACE_DIVIDER);
			lowerMap.append(MapComponent.SPACE_DIVIDER);
		}
	}

	private StringBuilder printSuccessOrFail() {
		StringBuilder successOrFail = new StringBuilder();

		successOrFail.append(OutputMessages.SUCCESS_OR_FAIL);
		if (gameResult.isGameClear()) {
			return successOrFail.append(OutputMessages.GAME_SUCCESS).append("\n");
		}
		return successOrFail.append(OutputMessages.GAME_FAIL).append("\n");
	}

	private StringBuilder printTotalTry() {
		StringBuilder totalTry = new StringBuilder();

		totalTry.append(OutputMessages.TOTAL_TRY);
		return totalTry.append(gameResult.getTotalTry()).append("\n");
	}

	private void resetOutputView() {
		moveHistory.clear();
	}
}
