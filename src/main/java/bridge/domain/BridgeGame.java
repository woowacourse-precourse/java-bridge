package bridge.domain;

import bridge.constant.BridgeConstants;
import bridge.constant.ExceptionConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final List<String> path = new ArrayList<>();
    private int attemptTimes = 1;

    public BridgeGame(String size) {
        bridge = new Bridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        isCorrectMoving(moving);
        path.add(moving);
    }

    private void isCorrectMoving(String moving) {
        if (!List.of(BridgeConstants.DOWN, BridgeConstants.UP).contains(moving)) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_MOVING.getMessage());
        }
    }

    public List<List<String>> makeMap() {
        List<List<String>> map = new ArrayList<>();
        map.add(makeRow(BridgeConstants.UP));
        map.add(makeRow(BridgeConstants.DOWN));
        return map;
    }

    private List<String> makeRow(String position) {
        return IntStream.range(0, path.size())
                .mapToObj(index -> makeSymbol(index, position))
                .collect(Collectors.toList());
    }

    private String makeSymbol(int index, String position) {
        if (path.get(index).equals(position)) {
            if (path.get(index).equals(bridge.get(index))) {
                return BridgeConstants.SUCCESS;
            }
            return BridgeConstants.FAILURE;
        }
        return BridgeConstants.SPACE;
    }

    public boolean isOngoing() {
        if (path.isEmpty()) {
            return true;
        }
        int pathLastIndex = path.size() - 1;
        return path.size() != bridge.size() && path.get(pathLastIndex).equals(bridge.get(pathLastIndex));
    }

    public boolean isWin() {
        int pathLastIndex = path.size() - 1;
        return path.size() == bridge.size() && path.get(pathLastIndex).equals(bridge.get(pathLastIndex));
    }

    public String calculateResult() {
        int pathLastIndex = path.size() - 1;
        if (path.get(pathLastIndex).equals(bridge.get(pathLastIndex))) {
            return BridgeConstants.WIN;
        }
        return BridgeConstants.LOSE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        isCorrectGameCommand(gameCommand);
        if (gameCommand.equals(BridgeConstants.RESTART)) {
            path.clear();
            attemptTimes++;
        }
    }

    private void isCorrectGameCommand(String gameCommand) {
        if (!List.of(BridgeConstants.RESTART, BridgeConstants.QUIT).contains(gameCommand)) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_GAME_COMMAND.getMessage());
        }
    }

    public int getAttemptTimes() {
        return attemptTimes;
    }
}
