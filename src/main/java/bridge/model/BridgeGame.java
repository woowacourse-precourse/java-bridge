package bridge.model;

import static bridge.model.RoundStatus.CLEAR;
import static bridge.model.RoundStatus.FAIL;
import static bridge.util.BridgeGameConstant.GAME_STATUS_MESSAGE;
import static bridge.util.BridgeGameConstant.TRY_COUNT_MESSAGE;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private Round round;
    private int tryCount;

    public BridgeGame(int bridgeSize) {
        this.bridge = makeBridge(bridgeSize);
        this.round = new Round();
        tryCount = 1;
    }

    private Bridge makeBridge(int bridgeSize) {
        List<String> path = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        return new Bridge(path);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (round.isMovable(bridge.getAccessibleIndexes(direction))) {
            round.updateStatusWhenMovable(direction);
            return;
        }
        round.updateStatusWhenImmovable(direction);
    }

    public String getMapToString() {
        List<String> map = round.getMap();
        return map.get(0) + "\n" + map.get(1);
    }

    public boolean isPlaying() {
        return round.isRoundPlaying(bridge.getDestinationIndex());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        round = new Round();
        tryCount++;
    }

    public Map<String, String> getResultToString() {
        Map<String, String> result = new HashMap<>(
                Map.of(TRY_COUNT_MESSAGE, Integer.toString(tryCount))
        );
        if (round.isClear()) {
            result.put(GAME_STATUS_MESSAGE, CLEAR.getText());
            return result;
        }
        result.put(GAME_STATUS_MESSAGE, FAIL.getText());
        return result;
    }

    public boolean isGameClear() {
        return round.isClear();
    }
}
