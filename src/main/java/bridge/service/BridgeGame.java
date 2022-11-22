package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int attempts = 1;
    private Bridge bridge;
    private Bridge user;

    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public int getAttempts() {
        return attempts;
    }

    public List<List<String>> getResult() {
        List<String> result = user.matchAnswer(bridge);

        return List.of(result, user.getBridge());
    }

    public void initBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        this.bridge = new Bridge(bridge);
        this.user = new Bridge(new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String next) {
        user.moveNext(next);
    }

    public GameStatus getCurrentStatus() {
        if (!user.isCorrectLastElement(bridge))
            return GameStatus.OVER;

        if (bridge.getSize()==user.getSize())
            return GameStatus.WIN;

        return GameStatus.CONTINUE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        attempts++;
        user = new Bridge(new ArrayList<>());
    }
}
