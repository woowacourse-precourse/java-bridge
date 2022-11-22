package bridge;

import repository.BridgeRepository;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BridgeGame {
    private static final String BRIDGE_SIZE_REGEX = "([3-9]|1[0-9]|20)";
    private static final String MOVE_DIRECTION_REGEX = "[UD]";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";

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

    public void saveResult() {
        List<String> progress = bridgeRepository.getProgress();
        bridgeRepository.resetResult();
        drawResult(progress);
    }

    private void drawResult(List<String> progress) {
        int lastMove = progress.size();
        IntStream.range(0, lastMove)
                .forEach(i -> bridgeRepository.saveResult(progress.get(i), i, SUCCESS));

        if (!canMove()) {
            bridgeRepository.saveResult(progress.get(lastMove - 1), lastMove - 1, FAIL);
        }
    }

    public boolean isWin() {
        return bridgeRepository.getBridge().equals(bridgeRepository.getProgress());
    }

    public Map<String, List<String>> getResult() {
        return bridgeRepository.getResult();
    }

    public boolean retryOrEnd(String command) {
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
