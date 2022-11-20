package bridge.presentation;

import bridge.PlayerMap;
import bridge.data.GameMessage;

import static bridge.data.GameMark.*;

public class OutputView {
    public void printGameStart() {
        System.out.println(GameMessage.GAME_START.getMessage());
    }

    public void printInputBridge() {
        System.out.println(GameMessage.INPUT_BRIDGE_SIZE.getMessage());
    }

    public void printBridgeSize(int bridgeSize) {
        System.out.println(bridgeSize);
        System.out.println();
    }

    public void printInputMove() {
        System.out.println(GameMessage.INPUT_MOVE.getMessage());
    }

    public void printMove(String move) {
        System.out.println(move);
    }

    public void printInputRetryCommand() {
        System.out.println(GameMessage.INPUT_RETRY_COMMAND.getMessage());
    }

    public void printRetryCommand(String retryCommand) {
        System.out.println(retryCommand);
    }

    public void printFinalResult() {
        System.out.println(GameMessage.GAME_FINAL_RESULT.getMessage());
    }

    private void printColumnMap(int row, PlayerMap playerMap, int position) {
        for (int j = 0; j < position; j++) {
            if (j > 0) {
                System.out.print(BLANK.getMark() + VERTICAL_BAR.getMark());
            }
            System.out.print(BLANK.getMark() + playerMap.getMark(row, j));
        }
        System.out.println(BLANK.getMark() + BRAKETS_RIGHT.getMark());
    }

    public void printMap(PlayerMap playerMap, int position) {
        for (int i = 0; i < 2; i++) {
            System.out.print(BRAKETS_LEFT.getMark());
            printColumnMap(i, playerMap, position);
        }
        System.out.println();
    }

    private String createSuccessOrFailureMessage(boolean isWon) {
        if (isWon) {
            return GameMessage.GAME_SUCCESS.getMessage();
        }
        return GameMessage.GAME_FAILURE.getMessage();
    }

    private void printTryCount(int tryCount) {
        String message = GameMessage.TRY_COUNT.getMessage() + COLON.getMark() + BLANK.getMark() + tryCount;
        System.out.println(message);
    }

    private void printSuccessOrNot(boolean isWon) {
        String successOrFailure = createSuccessOrFailureMessage(isWon);
        String message = GameMessage.GAME_SUCCESS_OR_NOT.getMessage() + COLON.getMark()
                + BLANK.getMark() + successOrFailure;
        System.out.println(message);
    }

    public void printResult(boolean isWon, int tryCount) {
        printSuccessOrNot(isWon);
        printTryCount(tryCount);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}

