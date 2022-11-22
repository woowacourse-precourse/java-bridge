package Model;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<String> mapUpper = new ArrayList<>();
    private List<String> mapLower = new ArrayList<>();
    private List<String> crossable;

    public Map(List<String> crossable) {
        this.crossable = crossable;
    }

    public List<String> getMapUpper() {
        return mapUpper;
    }

    public List<String> getMapLower() {
        return mapLower;
    }

    public List<String> getCrossable() {return crossable;}

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
        makeMapLower(answer.equals(Moving.Down.getMoving()));
        return answer.equals(Moving.Down.getMoving());
    }

    public boolean checkWhenInputIsU(String answer) {
        makeMapUpper(answer.equals(Moving.Up.getMoving()));
        return answer.equals(Moving.Up.getMoving());
    }

    public boolean runMap(String moving, String answer) {
        if (moving.equals(Moving.Down.getMoving())) {
            boolean isWin = checkWhenInputIsD(answer);
            return isWin;
        }

        boolean isWin = checkWhenInputIsU(answer);
        return isWin;
    }

}
