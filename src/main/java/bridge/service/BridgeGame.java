package bridge.service;

import static bridge.exception.Validator.validBridgeLength;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Round;
import bridge.domain.RoundResult;
import bridge.BridgeMaker;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private List<Round> rounds;

    public BridgeGame(int bridgeSize) {
        validBridgeLength(bridgeSize);
        setBridge(bridgeSize);
        this.rounds = new ArrayList<>();
    }

    public void setBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String playerMoving) {
        rounds.add(new Round(playerMoving, bridge.get(getCurrentNumberOfRounds())));
    }

    public int getCurrentNumberOfRounds() {
        return rounds.size();
    }

    public boolean isCurrentRoundResultFailure() {
        return rounds.get(rounds.size() - 1).getResult() == RoundResult.FAILURE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.rounds = new ArrayList<>();
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
