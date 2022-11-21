package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    public boolean isSuccess(List<String> bridges) {
        return IntStream.range(0, directions.size())
                .allMatch(index -> directions.get(index).equals(bridges.get(index)));
    }
}
