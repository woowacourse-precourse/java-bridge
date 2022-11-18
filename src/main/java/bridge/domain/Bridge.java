package bridge.domain;


import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
    private final Queue<String> directions;

    public Bridge(LinkedList<String> directions) {
        this.directions = directions;
    }

    public boolean isNotSame(String compare) {
        String direction = directions.poll();
        if(direction == null) {
            return false;
        }
        return !direction.equals(compare);
    }
}
