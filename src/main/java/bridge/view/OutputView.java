package bridge.view;

import java.util.List;

import bridge.GameRule;
import bridge.domain.BridgeRecord;

public class OutputView {

	private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	private static final String OPEN_BRIDGE_FORMAT = "[";
	private static final String CLOSE_BRIDGE_FORMAT = "]";
	private static final String BRIDGE_DIVISION_FORMAT = " %s |";
	private static final String GAME_END_MESSAGE = "최종 게임 결과";
	private static final String IS_SUCCESS_MESSAGE = "게임 성공 여부: %s\n";
	private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";
	private static final String SUCCESS_MESSAGE = "성공";
	private static final String FAIL_MESSAGE = "실패";

	public void printStart() {
		System.out.println(GAME_START_MESSAGE);
	}

	public void printMap(List<String[]> boards) {
		String upMap = OPEN_BRIDGE_FORMAT;
		String downMap = OPEN_BRIDGE_FORMAT;

		for (String[] board : boards) {
			String[] map = makeMap(board, upMap, downMap);
			upMap = map[0];
			downMap = map[1];
		}
		System.out.println(upMap.substring(0, upMap.length() - 1) + CLOSE_BRIDGE_FORMAT);
		System.out.println(downMap.substring(0, downMap.length() - 1) + CLOSE_BRIDGE_FORMAT);
	}

	private String[] makeMap(String[] board, String upMap, String downMap) {
		if (board[0].equals(GameRule.UP_BOARD)) {
			upMap += String.format(BRIDGE_DIVISION_FORMAT, board[1]);
			downMap += String.format(BRIDGE_DIVISION_FORMAT, " ");
		} else if (board[0].equals(GameRule.DOWN_BOARD)) {
			downMap += String.format(BRIDGE_DIVISION_FORMAT, board[1]);
			upMap += String.format(BRIDGE_DIVISION_FORMAT, " ");
		}
		return new String[] {upMap, downMap};
	}

	public void printResult(BridgeRecord bridgeRecord, boolean isSuccess) {
		System.out.println(GAME_END_MESSAGE);
		printMap(bridgeRecord.getBoards());
		System.out.printf(IS_SUCCESS_MESSAGE, convertToMessage(isSuccess));
		System.out.printf(TRY_COUNT_MESSAGE, bridgeRecord.getTryCount());
	}

	private String convertToMessage(boolean isSuccess) {
		if (isSuccess) {
			return SUCCESS_MESSAGE;
		}
		return FAIL_MESSAGE;
	}

}
