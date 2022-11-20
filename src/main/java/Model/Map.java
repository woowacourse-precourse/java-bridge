package Model;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<String> mapUpper = new ArrayList<>();
    private List<String> mapLower = new ArrayList<>();
    private List<String> crossable;
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
        mapUpper.add("   ");
        if (isCorrect) {
            mapLower.add(" O ");
            return;
        }
        mapLower.add(" X ");
    }


    public void makeMapUpper(boolean isCorrect) {
        mapLower.add("   ");
        if (isCorrect) {
            mapUpper.add(" O ");
            return;
        }
        mapUpper.add(" X ");
    }

    public void extendMap(int index) {
        if (index>0) {
            mapUpper.set(mapUpper.size()-1,"|");
            mapLower.set(mapLower.size()-1,"|");
        }
    }

    public boolean checkWhenInputIsD(String answer) {
        makeMapLower(answer.equals("D"));
        return answer.equals("D");
    }

    public boolean checkWhenInputIsU(String answer) {
        makeMapUpper(answer.equals("U"));
        return answer.equals("U");
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
