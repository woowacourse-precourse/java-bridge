package bridge.domain;

import java.util.List;
import java.util.StringJoiner;

import static bridge.constant.Constants.BridgeUtils.*;

public class GameBoard {

    private final List<String> gameBoard;

    public GameBoard(List<String> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void addMovingResult(String movingResult) {
        gameBoard.add(movingResult);
    }

    public StringJoiner createMap() {
        StringJoiner map = new StringJoiner(BRIDGE_SEPARATOR, BRIDGE_START, BRIDGE_FINISH);

        for (String value : gameBoard) {
            map.add(value);
        }
        return map;
    }

}
