package bridge.map;

import bridge.game.Moving;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private final List<String> up;
    private final List<String> down;

    public Map() {
        up = new ArrayList<>();
        down = new ArrayList<>();
    }

    public void addCrossing(String moving) {
        if (moving.equals(Moving.UP.getLetter())) {
            up.add(Crossing.SUCCESS.getLetter());
            down.add(Crossing.EMPTY.getLetter());
            return;
        }

        up.add(Crossing.EMPTY.getLetter());
        down.add(Crossing.SUCCESS.getLetter());
    }

    public void addNoCrossing(String moving) {
        if (moving.equals(Moving.UP.getLetter())) {
            up.add(Crossing.FAIL.getLetter());
            down.add(Crossing.EMPTY.getLetter());
            return;
        }

        up.add(Crossing.EMPTY.getLetter());
        down.add(Crossing.FAIL.getLetter());
    }

    @Override
    public String toString() {
        return format(up) + "\n" + format(down);
    }

    private String format(List<String> part) {
        StringBuilder result = new StringBuilder();
        result.append(Format.BEGIN.getLetters());

        String status = String.join(Format.DIVISION.getLetters(), part);
        result.append(status);

        result.append(Format.END.getLetters());
        return result.toString();
    }
}
