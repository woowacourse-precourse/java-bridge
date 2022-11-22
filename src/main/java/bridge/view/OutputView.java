package bridge.view;

import static bridge.controller.GameState.*;
import static bridge.view.ProgressMessage.*;

import java.util.List;

import bridge.controller.GameState;
import bridge.domain.BridgeConfiguration;

public class OutputView {
	public static void printMap(GameState result, List<String> moveRecord) {
		printWholeBridge(result, moveRecord);
		System.out.println();
	}

	public static void printWholeBridge(GameState result, List<String> moveRecord) {
		boolean lastBridgeState = checkLastBridge(moveRecord);
		System.out.print(DrawBridge.BRIDGE_START.getStructure());
		printMiddleBridge(moveRecord, BridgeConfiguration.U);
		printEndBridge(result, lastBridgeState);
		System.out.println(DrawBridge.BRIDGE_END.getStructure());
		System.out.print(DrawBridge.BRIDGE_START.getStructure());
		printMiddleBridge(moveRecord, BridgeConfiguration.D);
		printEndBridge(result, !lastBridgeState);
		System.out.println(DrawBridge.BRIDGE_END.getStructure());
	}

	public static boolean checkLastBridge(List<String> moveRecord) {
		String lastBridge = moveRecord.get(moveRecord.size() - 1);
		return lastBridge.equals(BridgeConfiguration.U.name());
	}

	public static void printMiddleBridge(List<String> moveRecord, BridgeConfiguration direction) {
		for (int i = 0; i < moveRecord.size() - 1; i++) {
			if (moveRecord.get(i).equals(direction.name())) {
				System.out.print("O");
				System.out.print(DrawBridge.BRIDGE_MIDDLE.getStructure());
				continue;
			}
			System.out.print(" ");
			System.out.print(DrawBridge.BRIDGE_MIDDLE.getStructure());
		}
	}

	public static void printEndBridge(GameState result, boolean lastBridgeState) {
		if (lastBridgeState && result.equals(SUCCESS_END) || lastBridgeState && result.equals(CONTINUATION)) {
			System.out.print("O");
		}
		if (lastBridgeState && result.equals(FAIL_END) || lastBridgeState && result.equals(SELECT_GAME_COMMAND)) {
			System.out.print("X");
		}
		if (!lastBridgeState) {
			System.out.print(" ");
		}
	}

	public static void printResult(GameState gameResult, int totalAttempt) {
		String result = GameResult.findResultName(gameResult);
		System.out.println(GAME_SUCCESSFUL.getMessage() + result);
		System.out.println(TOTAL_TRY_NUMBER.getMessage() + totalAttempt);
	}

	public static void printProgressMessage(ProgressMessage progress) {
		System.out.println(progress.getMessage());
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
