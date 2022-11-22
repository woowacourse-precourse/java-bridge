package bridge.util;

import bridge.dto.MapDTO;
import bridge.dto.PathDTO;
import bridge.model.User;
import java.util.stream.Collectors;

public class Converter {
    public MapDTO convertToMapDTO(User user) {
        return new MapDTO(user.getPath()
                .stream()
                .map(path -> new PathDTO(path.getDirection(), path.getPass()))
                .collect(Collectors.toList()));
    }
}
