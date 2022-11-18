package bridge.gamebridge;

import bridge.domain.Bridge;
import bridge.option.Move;
import bridge.result.Result;
import java.util.ArrayList;
import java.util.List;

public class GameBridge {
    private AnswerBridge answerBridge;
    private final PlayerBridge playerBridge;

    public GameBridge(){
        this.playerBridge = new PlayerBridge();
    }

    public void generateAnswerBridge(Bridge bridge) {
        this.answerBridge = new AnswerBridge(bridge);
    }

    public Result insertMove(Move move) {
        Bridge insertedBridge = insertMoveInPlayerBridge(move);
        return answerBridge.checkBridge(insertedBridge);
    }

    public PlayerBridge getPlayerBridge() {
        return playerBridge;
    }

    public Bridge insertMoveInPlayerBridge(Move move) {
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
