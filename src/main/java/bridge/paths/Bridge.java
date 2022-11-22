package bridge.paths;

import bridge.identifiers.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Direction> securePath;

    public Bridge(List<String> securePath) {
        validate(securePath);
        this.securePath = securePath.stream()
                .map(Direction::parseDirection)
                .collect(Collectors.toList());
    }

    private void validate(List<String> securePath) {
        if (securePath == null) {
            throw new IllegalStateException(
                    "컴퓨터 상태가 이상합니다."
            );
        }
    }

    public boolean canBeSteppedBy(PlayerPath playerPath) {
        List<Direction> path = playerPath.getPath();
        List<Direction> subSecurePath = securePath.subList(0, path.size());
        return subSecurePath.equals(path);
    }

    public boolean isCompletedWith(PlayerPath playerPath) {
        return securePath.equals(playerPath.getPath());
    }
}
