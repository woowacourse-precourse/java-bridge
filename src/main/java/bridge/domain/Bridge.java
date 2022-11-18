package bridge.domain;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bridge {
    private final List<String> directions;

    public Bridge(List<String> directions) {
        this.directions = directions;
    }

    public boolean hasSameDirection(Player player) {
        Queue<String> playerInputs = new LinkedList<>(player.getInputs());
        int start = 0;
        while(!playerInputs.isEmpty()) {
            if(isDifferent(directions.get(start), playerInputs.poll())) {
                return false;
            }
            start++;
        }
        return true;
    }

    public boolean isDifferent(String original, String expected) {
        return !original.equals(expected);
    }
}
