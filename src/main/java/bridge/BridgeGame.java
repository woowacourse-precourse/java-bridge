package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private final List<String> upperClass;
    private final List<String> lowerClass;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upperClass = new ArrayList<>(bridge.size());
        this.lowerClass = new ArrayList<>(bridge.size());
    }

    public boolean move(String moving, int count) {
        if (moving.equals("U")) {
            moveUp(moving, count);
        } else if (moving.equals("D")) {
            moveDown(moving, count);
        }

        return moving.equals(bridge.get(count));
    }

    private void moveUp(String moving, int count) {
        if (moving.equals(bridge.get(count))) {
            upperClass.add(count, "O");
            lowerClass.add(count, " ");
            return;
        }
        upperClass.add(count,"X");
        lowerClass.add(count, " ");
    }

    private void moveDown(String moving, int count) {
        if (moving.equals(bridge.get(count))) {
            lowerClass.add("O");
            upperClass.add(" ");
            return;
        }
        lowerClass.add("X");
        upperClass.add(" ");
    }

    public boolean retry(String commend) {
        return (commend.equals("Q"));
    }

    public List<List<String>> bridge() {
        return List.of(upperClass, lowerClass);
    }
}
