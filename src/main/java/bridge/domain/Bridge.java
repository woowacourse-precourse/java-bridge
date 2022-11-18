package bridge.domain;


import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
    private final Queue<String> directions;

    public Bridge(LinkedList<String> directions) {
        this.directions = directions;
    }
}
