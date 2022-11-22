package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Path> path = new ArrayList<>();

    public User() {
    }

    public void addPath(Path path) {
        this.path.add(path);
    }

    public List<Path> getPath() {
        return path;
    }

    public void clear() {
        path.clear();
    }
}
