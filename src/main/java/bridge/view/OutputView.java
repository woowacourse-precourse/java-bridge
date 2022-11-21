package bridge.view;

import bridge.domain.MoveStatus;
import bridge.domain.PlayResult;
import bridge.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.utils.Constants.*;

public class OutputView {

    public static void printMap(Player player) {
        List<MoveStatus> result = player.getPlayResult().getPlayResult();
        printUpperBridge(result);
        printLowerBridge(result);
    }

    public static void printResult(boolean gameContinue, Player player) {
        System.out.println(OUTPUT_MESSAGE_FINAL_GAME_RESULT);
        printMap(player);
        printSuccessMessage(gameContinue, player.getPlayResult());
    }

    private static void printUpperBridge(List<MoveStatus> result) {
        System.out.println(makeUpperBridge(result));
    }

    private static void printLowerBridge(List<MoveStatus> result) {
        System.out.println(makeLowerBridge(result));
    }

    private static void printSuccessMessage(boolean gameContinue, PlayResult playResult) {
        System.out.println(OUTPUT_MESSAGE_IS_SUCCESS_GAME + makeSuccessMessage(gameContinue));
        System.out.println(OUTPUT_MESSAGE_TOTAL_TRY_COUNT + playResult.getTryCount());
    }

    private static String makeUpperBridge(List<MoveStatus> result) {
        return OPEN_BRACKET + result.stream()
                .map(MoveStatus::getUpperSideMoveMessage)
                .collect(Collectors.joining(SEPARATOR)) + CLOSE_BRACKET;
    }

    private static String makeLowerBridge(List<MoveStatus> result) {
        return OPEN_BRACKET + result.stream()
                .map(MoveStatus::getDownSideMoveMessage)
                .collect(Collectors.joining(SEPARATOR)) + CLOSE_BRACKET;
    }

    private static String makeSuccessMessage(boolean gameContinue) {
        if (gameContinue) {
            return OUTPUT_MESSAGE_SUCCESS;
        }
        return OUTPUT_MESSAGE_FAIL;
    }
}
