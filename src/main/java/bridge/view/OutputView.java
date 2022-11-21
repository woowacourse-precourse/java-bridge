package bridge.view;

import static bridge.domain.State.*;

import java.util.List;

import bridge.domain.BridgeGame;
import bridge.domain.ProgressMap;

public class OutputView {
	private static final String PRINT_MAP_FIRST_LETTER = "[ ";
	private static final String PRINT_MAP_LAST_LETTER = " ]";
	private static final String PRINT_MAP_DELIMITER = " | ";

	public void printMap(ProgressMap result) {
		List<List<String>> gameResult = result.getProgressMap();
		String upBridge = createBridgeMap(gameResult.get(0));
		String downBridge = createBridgeMap(gameResult.get(1));
		System.out.println(upBridge);
		System.out.println(downBridge + "\n");
	}

	private String createBridgeMap(List<String> progress) {
		return PRINT_MAP_FIRST_LETTER
			+ String.join(PRINT_MAP_DELIMITER, progress)
			+ PRINT_MAP_LAST_LETTER;
	}

	public void printResult(ProgressMap result, BridgeGame bridgeGame) {
		if (bridgeGame.getState() == CLEAR) {
			printClearMap(result, bridgeGame.getRepeatCount());
		}
		if (bridgeGame.getState() == FAILED_CLEAR) {
			printFailedMap(result, bridgeGame.getRepeatCount());
		}
	}

	private void printClearMap(ProgressMap result, int count) {
		printResultIntro(result);
		System.out.println("게임 성공 여부: 성공");
		printResultOutro(count);
	}

	private void printFailedMap(ProgressMap result, int count) {
		printResultIntro(result);
		System.out.println("게임 성공 여부: 실패");
		printResultOutro(count);
	}

	private void printResultIntro(ProgressMap result) {
		System.out.println("최종 게임 결과");
		printMap(result);
	}

	private void printResultOutro(int count) {
		System.out.printf("총 시도한 횟수: %d%n", count);
	}
}
