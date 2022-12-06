package bridge;

import enumCollections.Side;
import enumCollections.UserInterfaceSymbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Map {
    private List<List<String>> bridgeUserInterface = new ArrayList<>();

    public Map() {
        bridgeUserInterface.add(new ArrayList<>());
        bridgeUserInterface.add(new ArrayList<>());
    }

    public List<List<String>> get() {
        return Collections.unmodifiableList(bridgeUserInterface);
    }

    public void add(Side playerMovedSide, boolean movable) {
        addSymbolToMap(playerMovedSide, UserInterfaceSymbol.getMovableSymbol(movable));
        addSymbolToMap(playerMovedSide.getOppositePosition(), UserInterfaceSymbol.BLANK.getSymbol());
    }

    public void initialize() {
        for (List<String> bridgeSide : bridgeUserInterface) {
            bridgeSide.clear();
        }
    }

    private void addSymbolToMap(Side side, String symbol) {
        this.bridgeUserInterface
                .get(side.getIndex())
                .add(symbol);
    }
}