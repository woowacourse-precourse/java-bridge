package bridge.model.Service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.domain.BridgeResult;
import bridge.model.domain.Map;
import bridge.model.domain.RoundTrace;
import bridge.model.validation.Command;
import bridge.model.validation.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bridge.model.constnce.Text.FAIL;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List <String> bridges;
    private final Map map;
    private final BridgeResult bridgeResult;

    public BridgeGame() {
        this.map = new Map();
        this.bridgeResult = new BridgeResult();
        this.bridges = new ArrayList <>();
    }

    public void retryGameSetting() {
        bridgeResult.init();
        bridgeResult.addAttempt();
        map.reset();
    }

    public void makeBridge(int input) {
        bridges.addAll(new ArrayList <>(bridgeMaker.makeBridge(input)));
    }

    public List <String> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public Map getMap() {
        return map;
    }

    public BridgeResult getBridgeResult() {
        return bridgeResult;
    }

    public boolean isClear() {
        return bridgeResult.getIsClear();
    }

    public boolean isLose() {
        return bridgeResult.getResult().equals(FAIL);
    }

    public void failedGame() {
        bridgeResult.failedGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String randomKey, Move move) {
        boolean isCorrect = move.isEquals(randomKey, move);
        if (!isCorrect) {
            bridgeResult.failedRound();
        }
        List <String> roundTrace = RoundTrace.makeTrace(randomKey, isCorrect);
        map.draw(roundTrace);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Command input) {
        return input.isRetry();
    }
}
