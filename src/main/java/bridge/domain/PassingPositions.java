package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PassingPositions {

    private final List<Position> passingPositions = new ArrayList<>();

    public PassingPositions() {
    }

    public void resetPassingPosition() {
        passingPositions.clear();
    }

    public List<Position> getPassingPositions() {
        return passingPositions;
    }

    public void addPassingPositions(int pos, String answer) {
        passingPositions.add(new Position(pos, answer));
    }
}
