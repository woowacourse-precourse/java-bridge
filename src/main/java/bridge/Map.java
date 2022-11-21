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

    private void addSymbolToMap(Side side, String symbol) {
        this.bridgeUserInterface.get(Side.getIndex(side))
                .add(symbol);
    }

    public List<List<String>> get() {
        return Collections.unmodifiableList(bridgeUserInterface);
    }

    public void add(Side playerMovedSide, boolean movable) {
        addSymbolToMap(playerMovedSide, UserInterfaceSymbol.getMovableSymbol(movable));
        addSymbolToMap(Side.getOppositePosition(playerMovedSide), UserInterfaceSymbol.getBlank());
    }

    public void initialize() {
        for (List<String> bridgeSide : bridgeUserInterface) {
            bridgeSide.clear();
        }
    }
}