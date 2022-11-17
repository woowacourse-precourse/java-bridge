package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PassingPositions {

//    private List<Position> passingPositions = new ArrayList<>();
    private final List<Position> passingPositions = new ArrayList<>();

    public void addPassingPositions(Position position) {
        passingPositions.add(position);
    }

    public void resetPassingPosition() {
        passingPositions.clear();
//        passingPositions = new ArrayList<>();
        System.out.println("passingPositions = " + passingPositions);
    }

    public List<Position> getPassingPositions() {
        return passingPositions;
    }
}
