package bridge.model;

import java.util.List;

public class User {
    private List<Path> path;

    public User(List<Path> path) {
        this.path = path;
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
