package bridge;

import enumCollections.GameResult;
import enumCollections.GameStatus;
import enumCollections.Position;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<List<String>> bridgeUserInterface = new ArrayList<>();

    public Map() {
        bridgeUserInterface.add(new ArrayList<>());
        bridgeUserInterface.add(new ArrayList<>());
    }

    public void add(Position position, String isSucceed) {
        this.bridgeUserInterface.get(Position.getIndex(position))
                .add(isSucceed);
    }

    public String get() {
        return this.bridgeUserInterface.toString();
    }

    public void add(BridgeGame bridgeGame, GameStatus gameStatus) {
        for (int bridgeIndex = 0; bridgeIndex < bridgeGame.getCurrentPosition(); bridgeIndex++) {
            add(Position.getPosition(
                    bridgeGame.getAvailableSquare(bridgeIndex)),
                    GameResult.getUi(GameResult.RIGHT_POSITION)
            );
        }
    }
}