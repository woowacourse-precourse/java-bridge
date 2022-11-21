package bridge;

public class Map {

    private String upMap = "[ ";
    private String downMap = "[ ";

    public void makeMap(String moving, String check) {
        if (moving.equals("U")) {
            if (upMap.length() > 2) {
                upMap += " | ";
                downMap += " | ";
            }
            upMap += check;
            downMap += " ";
        }
        if (moving.equals("D")) {
            if (downMap.length() > 2) {
                upMap += " | ";
                downMap += " | ";
            }
            upMap += " ";
            downMap += check;
        }
    }

    public String getUpMap() {
        return upMap + " ]";
    }

    public String getDownMap() {
        return downMap + " ]";
    }

    public void resetMap() {
        upMap = "";
        downMap = "";
    }
}
