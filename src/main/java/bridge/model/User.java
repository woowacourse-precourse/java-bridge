package bridge.model;

import bridge.dto.MapDTO;
import bridge.dto.PathDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public MapDTO convertToMapDTO() {
        return new MapDTO(
                path.stream()
                .map(path -> new PathDTO(path.getDirection(), path.getPass()))
                .collect(Collectors.toList())
        );
    }
}
