package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.Constants.*
        ;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> topMap;
    private List<String> bottomMap;
    private boolean playerQuit;
    private int tryCount;
    private int step;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
        topMap = new ArrayList<>();
        bottomMap = new ArrayList<>();
        playerQuit = false;
        tryCount = 1;
        step = 0;
    }

    public boolean isSuccess() {
        return bridge.size() == step;
    }

    public boolean isEnd() {
        return isSuccess() || playerQuit;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerDirection) {
        String answer = bridge.get(step);
        addHistoryToMap(answer, playerDirection);
        step++;
        return isSameDirection(answer, playerDirection);
    }

    private void addHistoryToMap(String answer, String playerDirection) {
        if (isSameDirection(answer, playerDirection)) {
            markToMap(playerDirection, O);
            return;
        }
        markToMap(playerDirection, X);
    }

    private void markToMap(String playerDirection, String marking) {
        if (playerDirection.equals(UP)) {
            addHistoryToEachMap(marking, BLANK);
            return;
        }
        addHistoryToEachMap(BLANK, marking);
    }

    private void addHistoryToEachMap(String top, String bottom) {
        topMap.add(top);
        bottomMap.add(bottom);
    }

    private boolean isSameDirection(String answer, String playerDirection) {
        return answer.equals(playerDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            topMap = new ArrayList<>();
            bottomMap = new ArrayList<>();
            tryCount++;
            step = 0;
            return;
        }
        playerQuit = true;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<List<String>> getMap() {
        return List.of(topMap, bottomMap);
    }
}
