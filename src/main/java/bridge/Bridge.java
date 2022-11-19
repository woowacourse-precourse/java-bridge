package bridge;

import java.util.List;

public class Bridge {
    private final List<String> path;

    public Bridge(List<String> path) {
        this.path = path;
    }

    public boolean isPassable(int round, String move) {
        return path.get(round).equals(move);
    }
}
