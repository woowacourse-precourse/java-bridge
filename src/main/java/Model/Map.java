package Model;

import java.util.ArrayList;
import java.util.List;

import Util.Util;
import View.InputView;
import View.OutputView;

public class Map {

    Util util = new Util();
    private List<String> mapUpper = new ArrayList<>();
    private List<String> mapLower = new ArrayList<>();
    private List<String> crossable;
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private int limitSize;

    public List<String> getMapUpper() {
        return mapUpper;
    }

    public List<String> getMapLower() {
        return mapLower;
    }

    public Map(List<String> crossable) {
        this.crossable = crossable;
        this.limitSize = crossable.size();
    }

    public void startMap() {
        mapUpper.clear();
        mapLower.clear();
        mapUpper.add("[");
        mapLower.add("[");
    }

    public void endMap() {
        mapUpper.add("]");
        mapLower.add("]");
    }

    public void makeMapLower(boolean isCorrect) {
        if (isCorrect) {
            mapUpper.add("   ");
            mapLower.add(" O ");
        }
        if (!isCorrect) {
            mapUpper.add("   ");
            mapLower.add(" X ");
        }
    }

    public void makeMapUpper(boolean isCorrect) {
        if (isCorrect) {
            mapUpper.add(" O ");
            mapLower.add("   ");
        }
        if (!isCorrect) {
            mapUpper.add(" X ");
            mapLower.add("   ");
        }
    }

    public void extendMap(int index) {
        if (index>0) {
            mapUpper.set(mapUpper.size()-1,"|");
            mapLower.set(mapLower.size()-1,"|");
        }
    }

    public boolean checkWhenInputIsD(String answer) {
        if (answer.equals("D")) {
            makeMapLower(true);
            return true;
        }
        if (!answer.equals("D")) {
            makeMapLower(false);
        }
        return false;
    }

    public boolean checkWhenInputIsU(String answer) {
        if (answer.equals("U")) {
            makeMapUpper(true);
            return true;
        }
        if (!answer.equals("U")) {
            makeMapUpper(false);
        }
        return false;
    }

    public boolean runMap(String moving, String answer) {
        boolean isWin = false;
        if (moving.equals("D")) {
            isWin = checkWhenInputIsD(answer);
        }
        if (moving.equals("U")) {
            isWin = checkWhenInputIsU(answer);
        }
        return isWin;
    }

}
