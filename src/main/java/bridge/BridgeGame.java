package bridge;

import repository.BridgeRepository;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String BRIDGE_SIZE_REGEX = "([3-9]|1[0-9]|20)";
    private static final String MOVE_DIRECTION_REGEX = "[UD]";

    private final BridgeRepository bridgeRepository;

    public BridgeGame(BridgeRepository bridgeRepository) {
        this.bridgeRepository = bridgeRepository;
    }

    public void generateBridge(String bridgeSize) {
        validateBridgeSize(bridgeSize);

        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(Integer.parseInt(bridgeSize));
        bridgeRepository.saveBridge(bridge);
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!Pattern.matches(BRIDGE_SIZE_REGEX, bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE);
        }
    }

    public void move(String direction) {
        validateMoveDirection(direction);
        bridgeRepository.saveProgress(direction);
    }

    private void validateMoveDirection(String direction) {
        if (!Pattern.matches(MOVE_DIRECTION_REGEX, direction)) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_DIRECTION);
        }
    }

    public boolean canMove() {
        List<String> bridge = bridgeRepository.getBridge();
        List<String> progress = bridgeRepository.getProgress();
        int lastMove = progress.size() - 1;

        if (progress.isEmpty()) {
            return true;
        }
        return progress.get(lastMove).equals(bridge.get(lastMove));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
