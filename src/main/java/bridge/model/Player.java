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

    String printFailureResult() {
        FailureResultPrinter failureResultPrinter = new FailureResultPrinter(directions);
        return failureResultPrinter.print();
    }

    String printSuccessResult() {
        SuccessResultPrinter successResultPrinter = new SuccessResultPrinter(directions);
        return successResultPrinter.print();
    }
}
