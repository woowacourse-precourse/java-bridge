package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Player {
    private final List<String> passingRout;

    Player() {
        this.passingRout = new ArrayList<>();
    }

    int move(String direction) {
        addDirection(direction);
        return passingRout.size();
    }

    private void addDirection(String direction) {
        passingRout.add(direction);
    }

    boolean isCompletedGame(int size) {
        return passingRout.size() == size;
    }

    boolean isStartStatus() {
        return passingRout.isEmpty();
    }

    String printResult(Boolean success) {
        return getResultPrinter(success).print();
    }

    private ResultPrinter getResultPrinter(Boolean success) {
        return ResultPrinter.createResultPrinter(success, getPassingRout());
    }

    private List<String> getPassingRout() {
        return List.copyOf(passingRout);
    }

    public boolean isSuccess(List<String> bridges) {
        return IntStream.range(0, passingRout.size())
                .allMatch(index -> isEquals(bridges, index));
    }

    private boolean isEquals(List<String> bridges, int index) {
        return passingRout.get(index).equals(bridges.get(index));
    }
}
