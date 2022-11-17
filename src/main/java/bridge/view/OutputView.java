package bridge.view;

import bridge.domain.MoveStatus;
import bridge.domain.PlayResult;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.utils.Constants.*;

public class OutputView {

    public static void printMap(PlayResult playResult) {
        List<MoveStatus> result = playResult.getPlayResult();
        printUpBridge(result);
        printDownBridge(result);
    }

    public static void printResult(boolean gameStatus, PlayResult playResult) {
        System.out.println(OUTPUT_MESSAGE_FINAL_GAME_RESULT);
        printMap(playResult);
        printSuccessMessage(gameStatus, playResult);
    }

    private static void printUpBridge(List<MoveStatus> result) {
        System.out.println(makeUpBridge(result));
    }

    private static void printDownBridge(List<MoveStatus> result) {
        System.out.println(makeDownBridge(result));
    }

    private static void printSuccessMessage(boolean gameStatus, PlayResult playResult) {
        System.out.println(OUTPUT_MESSAGE_IS_SUCCESS_GAME + makeSuccessMessage(gameStatus));
        System.out.println(OUTPUT_MESSAGE_TOTAL_TRY_COUNT + playResult.getTryCount());
    }

    private static String makeUpBridge(List<MoveStatus> result) {
        return OPEN_BRACKET + result.stream()
                .map(MoveStatus::isUpperSide)
                .collect(Collectors.joining(SEPARATOR)) + CLOSE_BRACKET;
    }

    private static String makeDownBridge(List<MoveStatus> result) {
        return OPEN_BRACKET + result.stream()
                .map(MoveStatus::isDownSide)
                .collect(Collectors.joining(SEPARATOR)) + CLOSE_BRACKET;
    }

    private static String makeSuccessMessage(boolean gameStatus) {
        if (gameStatus) {
            return OUTPUT_MESSAGE_SUCCESS;
        }
        return OUTPUT_MESSAGE_FAIL;
    }
}
