package bridge.domain.map;

import bridge.domain.bridge.CrossStatus;
import bridge.domain.direction.Direction;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.bridge.CrossStatus.FAIL;
import static bridge.domain.direction.Direction.UP;
import static bridge.domain.map.MapSymbol.*;
import static java.util.Collections.unmodifiableList;

public class BridgeMap {

    private final List<MapSymbol> topLine;
    private final List<MapSymbol> bottomLine;

    public BridgeMap() {
        topLine = new ArrayList<>();
        bottomLine = new ArrayList<>();

        init();
    }

    public void init() {
        topLine.clear();
        bottomLine.clear();

        topLine.add(START);
        bottomLine.add(START);
    }

    public List<MapSymbol> getTopLine() {
        ArrayList<MapSymbol> top = new ArrayList<>(topLine);
        top.add(END);
        return unmodifiableList(top);
    }

    public List<MapSymbol> getBottomLine() {
        ArrayList<MapSymbol> bottom = new ArrayList<>(bottomLine);
        bottom.add(END);
        return unmodifiableList(bottom);
    }

    public void addPath(final Direction direction,
                        final CrossStatus status) {
        if (status == FAIL) {
            addPath(direction, FAIL_PATH);
            return;
        }
        addPath(direction, PATH);
    }

    private void addPath(final Direction direction,
                         final MapSymbol symbol) {
        if (isUp(direction)) {
            drawTop(symbol);
            return;
        }
        drawBottom(symbol);
    }

    private boolean isUp(final Direction direction) {
        return direction == UP;
    }

    private void drawTop(final MapSymbol symbol) {
        drawSeparator();
        topLine.add(symbol);
        bottomLine.add(EMPTY);
    }

    private void drawBottom(final MapSymbol symbol) {
        drawSeparator();
        bottomLine.add(symbol);
        topLine.add(EMPTY);
    }

    private void drawSeparator() {
        topLine.add(SEPARATOR);
        bottomLine.add(SEPARATOR);
    }
}
