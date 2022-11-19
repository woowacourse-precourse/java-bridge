package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void validatePlayerStatus(Player player) {
        List<String> directions = player.getDirections();
        if (directions.size() > bridge.size()) {
            throw new IllegalStateException(
                    String.format("선택한 방향의 개수가 존재하는 다리를 초과했습니다. 다리 길이 : %d / 현재 위치 : %d", bridge.size(),
                            directions.size()));
        }
        if (hasMisMatchDirection(directions)) {
            throw new IllegalStateException(
                    String.format("이동이 불가능한 다리 방향을 가지고 있습니다. 방향 : %s", directions));
        }
    }

    private boolean hasMisMatchDirection(List<String> directions) {
        return IntStream.range(0, directions.size())
                .anyMatch(i -> !directions.get(i).equals(bridge.get(i)));
    }

    public boolean isDone(Player player) {
        List<String> directions = player.getDirections();
        return isSameLength(directions.size()) && isSameDirections(directions);
    }

    private boolean isSameLength(int length) {
        return bridge.size() == length;
    }

    private boolean isSameDirections(List<String> directions) {
        return IntStream.range(0, directions.size())
                .allMatch(i -> directions.get(i).equals(bridge.get(i)));
    }

    public List<String> getBridge() {
        return new ArrayList<>(bridge);
    }

}
