package view;

import static model.BridgeGameConstants.MOVING_SUCCESS;
import static model.BridgeGameConstants.MOVING_SUCCESS_GAME_END;
import static model.BridgeGameConstants.MOVING_FAIL_WRONG_MOVING;
import static model.BridgeGameConstants.MOVING_UP;
import static model.BridgeGameConstants.MOVING_DOWN;

import static view.OutputViewConstants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	private static String currentGameStateUpMap = OUTPUT_TEXT_OPEN_SQUARE_BRACKETS;
	private static String currentGameStarteDownMap = OUTPUT_TEXT_OPEN_SQUARE_BRACKETS;

	public void printGameStartMessage() {
		System.out.println(OUTPUT_TEXT_GAME_START);
		System.out.println();
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(String moving, int movingResult) {
		updateGameStateMap(moving, movingResult);
		String currentGameStateMap = combineGameStateUpMapAndDownMap();
		System.out.println(currentGameStateMap);
		System.out.println();
	}

	private String combineGameStateUpMapAndDownMap() {
		StringBuilder sb = new StringBuilder();
		String currentGameStateMap = sb.append(currentGameStateUpMap).append(NEW_LINE).append(currentGameStarteDownMap)
				.toString();
		return currentGameStateMap;
	}

	private void updateGameStateMap(String moving, int movingResult) {
		updateGameStateMapVerticalBar();
		updateGameStateMapWhenMovingUp(moving, movingResult);
		updateGameStateMapWhenMovingDown(moving, movingResult);
		updateGameStateMapCloseSquareBrackets();
	}

	private void updateGameStateMapVerticalBar() {
		currentGameStateUpMap = currentGameStateUpMap.replace(OUTPUT_TEXT_CLOSE_SQUARE_BRACKETS,
				OUTPUT_TEXT_VERTICAL_BAR);
		currentGameStarteDownMap = currentGameStarteDownMap.replace(OUTPUT_TEXT_CLOSE_SQUARE_BRACKETS,
				OUTPUT_TEXT_VERTICAL_BAR);
	}

	private void updateGameStateMapWhenMovingUp(String moving, int movingResult) {
		if (moving.equals(MOVING_UP) && (movingResult == MOVING_SUCCESS || movingResult == MOVING_SUCCESS_GAME_END)) {
			currentGameStateUpMap += OUTPUT_TEXT_MOVING_SUCCESS;
			currentGameStarteDownMap += OUTPUT_TEXT_DO_NOT_GO;
		}
		if (moving.equals(MOVING_UP) && movingResult == MOVING_FAIL_WRONG_MOVING) {
			currentGameStateUpMap += OUTPUT_TEXT_MOVING_FAIL;
			currentGameStarteDownMap += (OUTPUT_TEXT_DO_NOT_GO);
		}
	}

	private void updateGameStateMapWhenMovingDown(String moving, int movingResult) {
		if (moving.equals(MOVING_DOWN) && (movingResult == MOVING_SUCCESS || movingResult == MOVING_SUCCESS_GAME_END)) {
			currentGameStateUpMap += OUTPUT_TEXT_DO_NOT_GO;
			currentGameStarteDownMap += OUTPUT_TEXT_MOVING_SUCCESS;
		}
		if (moving.equals(MOVING_DOWN) && movingResult == MOVING_FAIL_WRONG_MOVING) {
			currentGameStateUpMap += (OUTPUT_TEXT_DO_NOT_GO);
			currentGameStarteDownMap += OUTPUT_TEXT_MOVING_FAIL;
		}
	}

	private void updateGameStateMapCloseSquareBrackets() {
		currentGameStateUpMap += OUTPUT_TEXT_CLOSE_SQUARE_BRACKETS;
		currentGameStarteDownMap += OUTPUT_TEXT_CLOSE_SQUARE_BRACKETS;
	}

	public void clearGameStateMap() {
		currentGameStateUpMap = OUTPUT_TEXT_OPEN_SQUARE_BRACKETS;
		currentGameStarteDownMap = OUTPUT_TEXT_OPEN_SQUARE_BRACKETS;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(int movingResult, int totalGameRound) {
		System.out.println(OUTPUT_TEXT_FINAL_GAME_RESULT);
		String currentGameStateMap = combineGameStateUpMapAndDownMap();
		System.out.println(currentGameStateMap);
		System.out.println();
		printGameResult(movingResult);
		printTotalGameRound(totalGameRound);
	}

	private void printGameResult(int movingResult) {
		if (movingResult == MOVING_SUCCESS_GAME_END) {
			System.out.println(OUTPUT_TEXT_GAME_SUCCESS);
		}
		if (movingResult == MOVING_FAIL_WRONG_MOVING) {
			System.out.println(OUTPUT_TEXT_GAME_FAIL);
		}
	}

	private void printTotalGameRound(int totalGameRound) {
		System.out.print(OUTPUT_TEXT_TOTAL_GAME_ROUND + totalGameRound);
	}
}
