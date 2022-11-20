package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> directions;

    Player() {
        this.directions = new ArrayList<>();
    }

    int move(String direction) {
        directions.add(direction);
        return directions.size();
    }

    boolean isCompletedGame(int size) {
        return directions.size() == size;
    }

    boolean isStartStatus() {
        return directions.isEmpty();
    }

    String printResult(Boolean success) {
        return ResultPrinter.createResultPrinter(success, directions).print();
    }
}
