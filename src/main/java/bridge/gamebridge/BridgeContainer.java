package bridge.gamebridge;

import static bridge.config.ExceptionMessage.EMPTY_ANSWER_BRIDGE;

import bridge.domain.Bridge;
import bridge.option.Move;
import bridge.result.Result;

public class BridgeContainer {

    private AnswerBridge answerBridge;
    private final PlayerBridge playerBridge;

    public BridgeContainer() {
        this.playerBridge = new PlayerBridge();
    }

    public void generateAnswerBridge(Bridge bridge) {
        this.answerBridge = new AnswerBridge(bridge);
    }

    public Result insertMove(Move move) {
        validate();
        Bridge insertedBridge = playerBridge.insertMove(move);
        return answerBridge.checkBridge(insertedBridge);
    }

    public void clearPlayerBridge() {
        playerBridge.clear();
    }

    private void validate() {
        if (answerBridge == null) {
            throw new IllegalArgumentException(EMPTY_ANSWER_BRIDGE.toString());
        }
    }
}
