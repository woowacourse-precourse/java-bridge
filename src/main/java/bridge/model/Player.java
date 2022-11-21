package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Position> passingRout;

    Player() {
        this.passingRout = new ArrayList<>();
    }

    int move(Position position) {
        this.addDirection(position);
        return this.passingRout.size();
    }

    private void addDirection(Position position) {
        this.passingRout.add(position);
    }

    boolean isCompletedGame(int size) {
        return this.passingRout.size() == size;
    }

    boolean isStartStatus() {
        return this.passingRout.isEmpty();
    }

    String printResult(Boolean success) {
        return this.getResultPrinter(success).print();
    }

    private ResultPrinter getResultPrinter(Boolean success) {
        return ResultPrinter.createResultPrinter(success, this.getPassingRout());
    }

    private List<Position> getPassingRout() {
        return List.copyOf(this.passingRout);
    }

    public boolean isSuccess(List<Position> bridges) {
        List<Position> target = bridges.subList(0, this.passingRout.size());
        return target.equals(this.passingRout);
    }


}
