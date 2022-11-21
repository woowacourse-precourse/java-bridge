package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RETRY_COMMAND = "R";

    private final List<String> bridge;
    private final List<String> userAnswer = new ArrayList<>();
    private int numberOfTry = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String location) {
        int compareLocation = userAnswer.size();
        userAnswer.add(location);
        return bridge.get(compareLocation).equals(location);
    }

    public List<BridgeEnum> currentBridge() {
        AtomicInteger startBridge = new AtomicInteger();
        return userAnswer.stream()
                .map(location -> BridgeEnum.createBridgeStringType(location, bridge.get(startBridge.getAndIncrement()).equals(location)))
                .collect(Collectors.toList());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryCommand) {
        return countRetry(RETRY_COMMAND.equals(retryCommand));
    }

    private boolean countRetry(boolean retry) {
        return retry;
    }
    }
}
