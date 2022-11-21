package bridge;

public class Map {

    private String upMap = "[ ";
    private String downMap = "[ ";

    public void makeMap(String moving, String check) {
        if (moving.equals("U")) {
            makeUpMap(check);
        }
        if (moving.equals("D")) {
            makeDownMap(check);
        }
    }

    public void makeUpMap(String check) {
        if (upMap.length() > 2) {
            upMap += " | ";
            downMap += " | ";
        }
        upMap += check;
        downMap += " ";
    }

    public void makeDownMap(String check) {
        if (downMap.length() > 2) {
            upMap += " | ";
            downMap += " | ";
        }
        upMap += " ";
        downMap += check;
    }

    public String getUpMap() {
        return upMap + " ]";
    }

    public String getDownMap() {
        return downMap + " ]";
    }

    public void resetMap() {
        upMap = "[ ";
        downMap = "[ ";
    }
}
