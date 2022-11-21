package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Position> passingRout;

    Player() {
        this.passingRout = new ArrayList<>();
    }

    int move(Position position) {
        addDirection(position);
        return passingRout.size();
    }

    private void addDirection(Position position) {
        passingRout.add(position);
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

    private List<Position> getPassingRout() {
        return List.copyOf(passingRout);
    }

    public boolean isSuccess(List<Position> bridges) {
        List<Position> target = bridges.subList(0, passingRout.size());
        return target.equals(passingRout);
    }


}
