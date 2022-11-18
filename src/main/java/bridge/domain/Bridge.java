package bridge.domain;


import java.util.List;

public class Bridge {
    private final List<String> directions;

    public Bridge(List<String> directions) {
        this.directions = directions;
    }

    public boolean hasSameDirection(Player player) {
        return !isDifferent(player.getLastInput(), directions.get(player.getLastIndex()));
    }

    public boolean isDifferent(String original, String expected) {
        return !original.equals(expected);
    }
}
