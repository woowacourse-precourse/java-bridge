package bridge;

import bridge.enums.MovingRandomNumber;

public class Map {
    private String START = "[ ";
    private String END = " ]";
    private String MIDDLE = " | ";
    private String NOTHING = " ";
    private String upMap = START;
    private String downMap = START;

    public void makeMap(String moving, String check) {
        if (moving.equals(MovingRandomNumber.UP.getMoving())) {
            makeUpMap(check);
        }
        if (moving.equals(MovingRandomNumber.DOWN.getMoving())) {
            makeDownMap(check);
        }
    }

    public void makeUpMap(String check) {
        if (upMap.length() > 2) {
            upMap += MIDDLE;
            downMap += MIDDLE;
        }
        upMap += check;
        downMap += NOTHING;
    }

    public void makeDownMap(String check) {
        if (downMap.length() > 2) {
            upMap += MIDDLE;
            downMap += MIDDLE;
        }
        upMap += NOTHING;
        downMap += check;
    }

    public String getUpMap() {
        return upMap + END;
    }

    public String getDownMap() {
        return downMap + END;
    }

    public void resetMap() {
        upMap = START;
        downMap = START;
    }
}
