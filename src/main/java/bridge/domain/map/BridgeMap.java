package bridge.domain.map;

import bridge.domain.bridge.CrossStatus;
import bridge.domain.direction.Direction;
import bridge.domain.mapmaker.MapSymbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bridge.domain.bridge.CrossStatus.FAIL;
import static bridge.domain.direction.Direction.UP;
import static bridge.domain.mapmaker.MapSymbol.*;

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
        return Collections.unmodifiableList(topLine);
    }

    public List<MapSymbol> getBottomLine() {
        return Collections.unmodifiableList(bottomLine);
    }

    public void addPath(final Direction direction,
                        final CrossStatus status) {
        if (status == FAIL) {
            addFailPath(direction);
            return;
        }
        addSuccessPath(direction);
    }

    private void addSuccessPath(final Direction direction) {
        if (isUp(direction)) {
            drawTop(PATH);
            return;
        }
        drawBottom(PATH);
    }

    private void addFailPath(final Direction direction) {
        if (isUp(direction)) {
            drawTop(FAIL_PATH);
            return;
        }
        drawBottom(FAIL_PATH);
    }

    private boolean isUp(final Direction direction) {
        return direction == UP;
    }

    private void drawTop(final MapSymbol symbol) {
        topLine.add(SEPARATOR);
        bottomLine.add(SEPARATOR);

        topLine.add(symbol);
        bottomLine.add(EMPTY);
    }

    private void drawBottom(final MapSymbol symbol) {
        topLine.add(SEPARATOR);
        bottomLine.add(SEPARATOR);

        bottomLine.add(symbol);
        topLine.add(EMPTY);
    }
}
