package bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeInform {
    private final int size;
    private String exit;
    private List<String> directions = new ArrayList<>();
    private int directionsize = 0;

    BridgeInform(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setDirection(String direction) {
        this.directionsize++;
        directions.add(direction);
    }

    public List<String> getDirection() {
        return directions;
    }

    public void initDirection() {
        this.directions.clear();
    }

    public void setExit(String exit) {
        this.exit = exit;
    }
}
