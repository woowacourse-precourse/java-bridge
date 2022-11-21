package bridge;

import enumCollections.GameStatus;
import enumCollections.Side;
import enumCollections.UserInterfaceSymbol;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<List<String>> bridgeUserInterface = new ArrayList<>();

    public Map() {
        bridgeUserInterface.add(new ArrayList<>());
        bridgeUserInterface.add(new ArrayList<>());
    }

    private void add(Side side, String isSucceed) {
        this.bridgeUserInterface.get(Side.getIndex(side))
                .add(isSucceed);
        this.bridgeUserInterface.get((Side.getIndex(side) + 1 ) % 2)
                .add(UserInterfaceSymbol.get(UserInterfaceSymbol.BLANK));
    }

    public List<List<String>> get() {
        return bridgeUserInterface;
    }

    public void add(Side side, GameStatus gameStatus) {
        String isSucceed = "O";
        if (gameStatus == GameStatus.FAILURE) {
            isSucceed = "X";
            side = Side.getOppositePosition(side);
        }
        add(side, isSucceed);
    }
}