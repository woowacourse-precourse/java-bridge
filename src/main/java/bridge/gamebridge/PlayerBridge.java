package bridge.gamebridge;

import bridge.domain.Bridge;
import bridge.command.Move;
import java.util.ArrayList;
import java.util.List;

public class PlayerBridge {

    private Bridge bridge;

    public void clear() {
        this.bridge = null;
    }

    public Bridge insertMove(Move move) {
        if (isEmpty()) {
            insertMoveInEmptyBridge(move);
            return bridge;
        }
        insertMoveInBridge(move);
        return bridge;
    }

    private void insertMoveInBridge(Move move) {
        bridge = makeNewBridge(move);
    }

    private Bridge makeNewBridge(Move move) {
        List<String> currentSquares = new ArrayList<>(bridge.getSquares());
        currentSquares.add(move.getMove());
        return new Bridge(currentSquares);
    }

    private void insertMoveInEmptyBridge(Move move) {
        List<String> square = List.of(move.getMove());
        bridge = new Bridge(square);
    }

    private boolean isEmpty() {
        return bridge == null;
    }
}
