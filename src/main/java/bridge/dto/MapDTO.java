package bridge.dto;

import java.util.List;

public class MapDTO {
    private final List<PathDTO> path;

    public MapDTO(List<PathDTO> path) {
        this.path = path;
    }

    public List<PathDTO> getPath() {
        return path;
    }
}
