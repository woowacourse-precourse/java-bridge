package bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeInform {
    private final int size;
    private String exit;
    private List<String> directions = new ArrayList<>();

    BridgeInform(int size) {
        validateRange(size);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setDirection(String direction) {
        validateCorrectDirection(direction);
        directions.add(direction);
    }

    public String getLastDirection() {
        String lastdirection = directions.get(directions.size());
        return lastdirection;
    }

    public String getIndexDirection(int index) {
        String indexdirection = directions.get(index);
        return indexdirection;
    }

    public void setExit(String exit) {
        validateCorrectExit(exit);
        this.exit = exit;
    }

    private void validateRange(int size) {
        if(size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateCorrectDirection(String direction) {
        if(direction.equals("U") == false && direction.equals("D") == false) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateCorrectExit(String direction) {
        if(direction.equals("R") == false && directions.equals("Q") == false) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
