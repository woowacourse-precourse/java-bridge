package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> passingRout;

    Player() {
        this.passingRout = new ArrayList<>();
    }

    int move(String direction) {
        passingRout.add(direction);
        return passingRout.size();
    }

    boolean isCompletedGame(int size) {
        return passingRout.size() == size;
    }

    boolean isStartStatus() {
        return passingRout.isEmpty();
    }

    String printResult(Boolean success) {
        return ResultPrinter.createResultPrinter(success, passingRout).print();
    }

    public boolean isSuccess(List<String> bridges) {
        return SuccessRoutValidator.isSuccess(bridges, List.copyOf(passingRout));
    }
}
