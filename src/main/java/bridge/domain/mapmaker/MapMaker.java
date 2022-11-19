package bridge.domain.mapmaker;

import bridge.domain.bridge.CrossStatus;
import bridge.domain.direction.Direction;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.direction.Direction.UP;
import static bridge.domain.mapmaker.MapSymbol.*;

public class MapMaker {

    private static final String NEW_LINT = "\n";
    private static final String SEPARATOR_REGEX = "\\|";
    private static final String EMPTY_STRING = "";

    private final List<MapSymbol> topLine;
    private final List<MapSymbol> bottomLine;

    public MapMaker() {
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

    public void addPath(final Direction direction,
                        final CrossStatus status) {
        if (status == CrossStatus.FAIL) {
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

    public String getCurrentMap() {
        String topMap = mapToString(topLine);
        String bottomMap = mapToString(bottomLine);
        return topMap + NEW_LINT + bottomMap;
    }

    private String mapToString(final List<MapSymbol> topLine) {
        StringBuilder sb = new StringBuilder();
        for (MapSymbol mapSymbol : topLine) {
            sb.append(mapSymbol.symbol());
        }
        sb.append(END.symbol());
        return sb.toString().replaceFirst(SEPARATOR_REGEX, EMPTY_STRING);
    }
}
