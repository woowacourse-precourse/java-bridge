package bridge.gamebridge;

import static bridge.config.ExceptionMessage.ALREADY_EXIT_ANSWER_BRIDGE;
import static bridge.config.ExceptionMessage.EMPTY_ANSWER_BRIDGE;

import bridge.domain.Bridge;
import bridge.command.Move;
import bridge.result.Result;

public class BridgeContainer {

    private final PlayerBridge playerBridge;
    private AnswerBridge answerBridge;

    public BridgeContainer() {
        this.playerBridge = new PlayerBridge();
    }

    public void generateAnswerBridge(Bridge bridge) {
        validateAnswerBridgeAlreadyExist();
        this.answerBridge = new AnswerBridge(bridge);
    }

    public Result insertMove(Move move) {
        validateEmptyAnswerBridge();
        Bridge insertedBridge = playerBridge.insertMove(move);
        return answerBridge.checkBridge(insertedBridge);
    }

    public void clearPlayerBridge() {
        playerBridge.clear();
    }

    private void validateEmptyAnswerBridge() {
        if (isEmptyAnswerBridge()) {
            throw new IllegalArgumentException(EMPTY_ANSWER_BRIDGE.toString());
        }
    }

    private void validateAnswerBridgeAlreadyExist() {
        if (!isEmptyAnswerBridge()) {
            throw new IllegalArgumentException(ALREADY_EXIT_ANSWER_BRIDGE.toString());
        }
    }

    private boolean isEmptyAnswerBridge() {
        return answerBridge == null;
    }
}
