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

    private void add(Side side, String isSucceed) {
        addSymbolToMap(side, isSucceed);
        addSymbolToMap(Side.getOppositePosition(side), UserInterfaceSymbol.getBlank());
    }

    private void addSymbolToMap(Side side, String symbol) {
        this.bridgeUserInterface.get(Side.getIndex(side))
                .add(symbol);
    }

    public List<List<String>> get() {
        return Collections.unmodifiableList(bridgeUserInterface);
    }

    public void add(Side side, boolean moved) {
        String isSucceed = UserInterfaceSymbol.get(UserInterfaceSymbol.AVAILABLE_TO_MOVE);
        if (!moved) {
            isSucceed = UserInterfaceSymbol.get(UserInterfaceSymbol.UNAVAILABLE_TO_MOVE);
            side = Side.getOppositePosition(side);
        }
        add(side, isSucceed);
    }

    public void initialize() {
        for (List<String> bridgeSide : bridgeUserInterface) {
            bridgeSide.clear();
        }
    }
}