package bridge;

import enumCollections.GameResult;
import enumCollections.GameStatus;
import enumCollections.Position;
import jdk.dynalink.beans.BeansLinker;

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
        this.bridgeUserInterface.get((Position.getIndex(position) + 1 ) % 2)
                .add(GameResult.getUi(GameResult.EMPTY));
    }

    public List<List<String>> get() {
        return bridgeUserInterface;
    }

    public void add(BridgeGame bridgeGame, GameStatus gameStatus) {
        String isSucceed = "O";
        Position position = Position.UP;
        if (gameStatus == GameStatus.FAILURE) {
            isSucceed = "X";
            position = Position.getOppositePosition(position);
        }
        add(position, isSucceed);
    }
}