package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.ShownMap;

import java.util.List;

public class MapConverter {

    private final static Character SUCCESS = 'O';
    private final static Character FAIL = 'X';
    private final static Character BLANK = ' ';

    private final ShownMap shownMap;

    public MapConverter() {
        this.shownMap = new ShownMap();
    }

    public void reset() {
        shownMap.clear();
    }

    public List<List<Character>> getDrawnMap() {
        return shownMap.getShownMap();
    }

    public void drawNext(String movement, boolean success) {
        if (movement.equals(BridgeMaker.UP)) {
            drawUpperMap(success);
            return;
        }
        drawLowerMap(success);
    }

    private void drawUpperMap(boolean success) {
        if (success) {
            drawUpperMapWithSuccess();
            return;
        }
        drawUpperMapWithFail();
    }

    private void drawLowerMap(boolean success) {
        if (success) {
            drawLowerMapWithSuccess();
            return;
        }
        drawLowerMapWithFail();
    }

    private void drawUpperMapWithSuccess() {
        shownMap.addUpper(SUCCESS);
        shownMap.addLower(BLANK);
    }

    private void drawUpperMapWithFail() {
        shownMap.addUpper(FAIL);
        shownMap.addLower(BLANK);
    }

    private void drawLowerMapWithSuccess() {
        shownMap.addUpper(BLANK);
        shownMap.addLower(SUCCESS);
    }

    private void drawLowerMapWithFail() {
        shownMap.addUpper(BLANK);
        shownMap.addLower(FAIL);
    }
}
