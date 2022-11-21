package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.repository.BridgeMakerRepository;
import bridge.repository.CompareBridgeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMakerRepository bridgeMakerRepository;
    private CompareBridgeRepository compareBridgeRepository;
    private int attempts = 1;
    private final List<String> movingChoices = new ArrayList<>();

    public BridgeGame() {
    }

    public List<String> createBridge(int bridgeSize) {
        bridgeMakerRepository = new BridgeMakerRepository(new BridgeRandomNumberGenerator());
        return bridgeMakerRepository.makeBridge(bridgeSize);
    }

    public List<String> createMovingChoices(String moving) {
        movingChoices.add(moving);
        return movingChoices;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Player player, List<String> bridge) {
        compareBridgeRepository = new CompareBridgeRepository(player, bridge);
        return compareBridgeRepository.stepping(player, bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        attempts++;
        return gameCommand.equals("R");
    }

    public String getSuccessOrNot(String gameCommand, List<String> movingChoices, List<String> bridge) {
        if (gameCommand.equals("Q")) {
            return "실패";
        }
        if (movingChoices.size() == bridge.size()) {
            return "성공";
        }
        return null;
    }

    public int getAttempts() {
        return attempts;
    }
}
