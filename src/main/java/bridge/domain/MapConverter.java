package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MapConverter {

    private final static Character SUCCESS = 'O';
    private final static Character FAIL = 'X';
    private final static Character BLANK = ' ';

    private final List<Character> upperMap;
    private final List<Character> lowerMap;


    public MapConverter() {
        this.upperMap = new ArrayList<>();
        this.lowerMap = new ArrayList<>();
    }

    public void initialize() {
        upperMap.clear();
        lowerMap.clear();
    }

    public List<Character> getUpperMap() {
        return upperMap;
    }

    public List<Character> getLowerMap() {
        return lowerMap;
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
        upperMap.add(SUCCESS);
        lowerMap.add(BLANK);
    }

    private void drawUpperMapWithFail() {
        upperMap.add(FAIL);
        lowerMap.add(BLANK);
    }

    private void drawLowerMapWithSuccess() {
        lowerMap.add(SUCCESS);
        upperMap.add(BLANK);
    }

    private void drawLowerMapWithFail() {
        lowerMap.add(FAIL);
        upperMap.add(BLANK);
    }
}
