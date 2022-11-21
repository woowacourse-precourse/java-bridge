package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.util.Constant;
import bridge.domain.util.ValidationUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int bridgeSize;
    private final MoveResultJudgement moveResultJudgement;
    private int currentDistance = 0;
    private int retry = 1;
    private boolean isGame = false;
    private BridgeMap bridgeMap = new BridgeMap();

    public BridgeGame(int readBridgeSize) {
        try {
            ValidationUtil.bridgeSizeValidation(readBridgeSize);
        } catch (IllegalArgumentException err) {
            System.out.println(err);
        }
        this.bridgeSize = readBridgeSize;
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        this.moveResultJudgement = new MoveResultJudgement(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean move(String moving) {
        if (moveResultJudgement.movedResult(moving, currentDistance)) {
            currentDistance++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        ValidationUtil.restartValidation(gameCommand);
        bridgeInitialization();
        retry++;
        return Objects.equals(gameCommand, Constant.RESTART);
    }

    private void bridgeInitialization() {
        currentDistance = 0;
        bridgeMap.initialization();
    }

    public boolean isGameComplete(String moving) {
        if (moveResultJudgement.isGameComplete(moving, currentDistance)) {
            isGame = true;
            return true;
        }
        return false;
    }

    public void createMap(String moving) {
        bridgeMap.createMap(moveResultJudgement.movedResult(moving, currentDistance), moving);
    }

    public LinkedHashMap<String, List<String>> getBridgeMap() {
        return bridgeMap.getMap();
    }

    public boolean getIsGame() {
        return isGame;
    }

    public int getRetry() {
        return retry;
    }
}
