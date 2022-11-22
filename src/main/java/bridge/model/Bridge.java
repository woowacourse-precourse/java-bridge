package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Bridge {

    private static final String EXCEED_COUNT_MESSAGE = "방향의 개수가 존재하는 다리를 초과했습니다. 다리 길이 : %d / 현재 위치 : %d";
    private static final String MISMATCH_MESSAGE = "다리와 일치하지 않는 방향을 가지고 있습니다. 방향 : %s";

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void validatePlayer(Player player) {
        List<String> directions = player.getDirections();
        validateCount(directions);
        validateMatch(directions);
    }

    private void validateCount(List<String> directions) {
        if (directions.size() > bridge.size()) {
            throw new IllegalStateException(
                    String.format(EXCEED_COUNT_MESSAGE, bridge.size(), directions.size()));
        }
    }

    private void validateMatch(List<String> directions) {
        if (hasMismatchDirection(directions)) {
            throw new IllegalStateException(
                    String.format(MISMATCH_MESSAGE, directions));
        }
    }

    private boolean hasMismatchDirection(List<String> directions) {
        return IntStream.range(0, directions.size())
                .anyMatch(i -> !directions.get(i).equals(bridge.get(i)));
    }

    public boolean isDone(Player player) {
        List<String> directions = player.getDirections();
        return isSameCount(directions) && isMatchDirections(directions);
    }

    private boolean isSameCount(List<String> directions) {
        return bridge.size() == directions.size();
    }

    private boolean isMatchDirections(List<String> directions) {
        return IntStream.range(0, directions.size())
                .allMatch(i -> directions.get(i).equals(bridge.get(i)));
    }

    public List<String> getBridge() {
        return new ArrayList<>(bridge);
    }

}
