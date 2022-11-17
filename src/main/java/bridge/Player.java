package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> paths;

    public Player() {
        this.paths = new ArrayList<>();
    }

    public int move(String direction) {
        paths.add(direction);
        return paths.size();
    }

    public boolean isCompleted(int size) {
        return paths.size() == size;
    }

    public boolean isStartStatus() {
        return paths.isEmpty();
    }
}
