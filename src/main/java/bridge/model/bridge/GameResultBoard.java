package bridge.model.bridge;

import bridge.model.game.Direction;

import java.util.ArrayList;
import java.util.List;

public class GameResultBoard {
    private final List<String> upperResult = new ArrayList<>();
    private final List<String> lowerResult = new ArrayList<>();

    public void update(String direction, boolean success) {
        if (direction.equals(Direction.D.name())) {
            upperResult.add(" ");
            lowerResult.add(marking(success));
            return;
        }
        upperResult.add(marking(success));
        lowerResult.add(" ");
    }

    private String marking(boolean sucess) {
        if (sucess) return "O";
        return "X";
    }

    public List<List<String>> getState() {
        return new ArrayList<>(List.of(upperResult, lowerResult));
    }
}
