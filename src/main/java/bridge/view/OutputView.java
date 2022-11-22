package bridge.view;

import static bridge.view.OutputMessage.BRIDGE_EMPTY;
import static bridge.view.OutputMessage.BRIDGE_END;
import static bridge.view.OutputMessage.BRIDGE_MATCHED;
import static bridge.view.OutputMessage.BRIDGE_SEPARATOR;
import static bridge.view.OutputMessage.BRIDGE_START;
import static bridge.view.OutputMessage.BRIDGE_UNMATCHED;
import static bridge.view.OutputMessage.GAME_END;
import static bridge.view.OutputMessage.GAME_FAIL;
import static bridge.view.OutputMessage.GAME_REQUEST_BRIDGE_LENGTH;
import static bridge.view.OutputMessage.GAME_REQUEST_POSITION;
import static bridge.view.OutputMessage.GAME_REQUEST_RETRY;
import static bridge.view.OutputMessage.GAME_START;
import static bridge.view.OutputMessage.GAME_SUCCESS;
import static bridge.view.OutputMessage.GAME_TOTAL_TRY_COUNT;
import static bridge.view.OutputMessage.GAME_WHETHER_SUCCESS;

import bridge.bridge.BridgePosition;
import bridge.bridgeGame.BridgeGame;
import bridge.bridgeGame.BridgeGameState;
import bridge.bridgeGame.GameCommand;

public class OutputView {
    public void printMap(BridgeGameState bridgeGameState) {
        printLine(bridgeGameState, BridgePosition.BRIDGE_UP);
        printLine(bridgeGameState, BridgePosition.BRIDGE_DOWN);
        System.out.println();
    }

    private void printLine(BridgeGameState bridgeGameState, BridgePosition position) {
        System.out.print(BRIDGE_START.getMessage());
        for (int i = 0; i < bridgeGameState.currentSize(); ++i) {
            if (i != 0) {
                System.out.print(BRIDGE_SEPARATOR.getMessage());
            }
            System.out.print(getMatchString(bridgeGameState.getCurrentAt(i), bridgeGameState.getMatched(i), position));
        }
        System.out.println(BRIDGE_END.getMessage());
    }

    private String getMatchString(String currentAt, boolean matched, BridgePosition position) {
        if (!currentAt.equals(position.getPosition())) {
            return BRIDGE_EMPTY.getMessage();
        }
        if (matched) {
            return BRIDGE_MATCHED.getMessage();
        }
        return BRIDGE_UNMATCHED.getMessage();
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_END.getMessage());
        printMap(bridgeGame.getBridgeGameState());
        System.out.println(GAME_WHETHER_SUCCESS.getMessage() + getSuccessString(bridgeGame.isWon()));
        System.out.println(GAME_TOTAL_TRY_COUNT.getMessage() + bridgeGame.getTryCount());
    }

    private String getSuccessString(boolean isSuccess) {
        if (isSuccess) {
            return GAME_SUCCESS.getMessage();
        }
        return GAME_FAIL.getMessage();
    }

    public void printInitGameMessage() {
        System.out.println(GAME_START.getMessage());
        System.out.println();
        System.out.println(GAME_REQUEST_BRIDGE_LENGTH.getMessage());
    }

    public void printRequestBridgeMoving() {
        System.out.printf(GAME_REQUEST_POSITION.getMessage(), BridgePosition.BRIDGE_UP.getPosition(),
                BridgePosition.BRIDGE_DOWN.getPosition());
    }

    public void printRequestGameRetry() {
        System.out.printf(GAME_REQUEST_RETRY.getMessage(), GameCommand.COMMAND_RETRY.getCommandString(),
                GameCommand.COMMAND_QUIT.getCommandString());
    }
}
