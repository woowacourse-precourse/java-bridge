package bridge.gamebridge;

import static bridge.config.ExceptionMessage.EMPTY_ANSWER_BRIDGE;

import bridge.domain.Bridge;
import bridge.option.Move;
import bridge.result.Result;
import java.util.ArrayList;
import java.util.List;

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
        Bridge insertedBridge = insertMoveInPlayerBridge(move);
        return answerBridge.checkBridge(insertedBridge);
    }

    public PlayerBridge getPlayerBridge() {
        return playerBridge;
    }

    public void clearPlayerBridge() {
        playerBridge.clear();
    }

    private void validate() {
        if (answerBridge == null) {
            throw new IllegalArgumentException(EMPTY_ANSWER_BRIDGE.toString());
        }
    }

    private Bridge insertMoveInPlayerBridge(Move move) {
        if (playerBridge.isEmpty()) {
            return moveInEmptyBridge(move);
        }
        return moveSquare(move);
    }

    private Bridge moveSquare(Move move) {
        Bridge bridge = playerBridge.getBridge();
        playerBridge.setBridge(makeNewBridge(move, bridge));
        return playerBridge.getBridge();
    }

    private Bridge makeNewBridge(Move move, Bridge bridge) {
        List<String> currentSquares = new ArrayList<>(bridge.getSquares());
        currentSquares.add(move.getMove());
        return new Bridge(currentSquares);
    }

    private Bridge moveInEmptyBridge(Move move) {
        List<String> square = List.of(move.getMove());
        playerBridge.setBridge(new Bridge(square));
        return playerBridge.getBridge();
    }
}
