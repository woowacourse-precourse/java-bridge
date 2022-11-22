package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.repository.BridgeMakerRepository;
import bridge.repository.CompareBridgeRepository;
import bridge.service.enums.GameCommand;
import bridge.service.enums.GameResult;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMakerRepository bridgeMakerRepository;
    private CompareBridgeRepository compareBridgeRepository;
    private int attempts = 1;

    public BridgeGame() {
    }

    public List<String> createBridge(int bridgeSize) {
        bridgeMakerRepository = new BridgeMakerRepository(new BridgeRandomNumberGenerator());
        return bridgeMakerRepository.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Boolean> move(Player player, List<String> bridge) {
        compareBridgeRepository = new CompareBridgeRepository(bridge);
        return compareBridgeRepository.canStepping(player);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY.getType())) {
            attempts++;
            return true;
        }
        return false;
    }

    public boolean isEnd(String gameCommand, List<String> movingChoices, List<String> bridge) {
        if (gameCommand.equals(GameCommand.QUIT.getType())) {
            return true;
        }
        if (movingChoices.size() == bridge.size()) {
            return true;
        }
        return false;
    }

    public String getSuccessOrNot(String gameCommand, List<String> movingChoices, List<String> bridge) {
        if (gameCommand.equals(GameCommand.QUIT.getType())) {
            return GameResult.FAIL.getType();
        }
        if (movingChoices.size() == bridge.size()) {
            return GameResult.SUCCESS.getType();
        }
        return null;
    }

    public int getAttempts() {
        return attempts;
    }
}