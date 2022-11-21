package bridge;

public class Map {

    private String upMap = "";
    private String downMap = "";

    public void makeMap(String moving, String check) {
        if (moving.equals("U")) {
            upMap += "[ " + check;
            downMap += "[ " + " ";
        }
        if (moving.equals("D")) {
            upMap += "[ " + " ";
            downMap += "[ " + check;
        }
    }

    public void addMap(String moving, String check) {
        if (moving.equals("U")) {
            upMap += " | " + check;
            downMap += " | " + " ";
        }
        if (moving.equals("D")) {
            upMap += " | " + " ";
            downMap += " | " + check;
        }
    }

    public String getUpMap() {
        return upMap + " ]";
    }

    public String getDownMap() {
        return downMap + " ]";
    }
}
