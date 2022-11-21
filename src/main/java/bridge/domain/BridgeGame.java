package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.KeyboardCommand;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int COUNT_INITIAL_VALUE = 0;
    private final int ATTEMPTS_INITIAL_VALUE = 1;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator numberGenerator;
    private List<String> bridge;
    private int count;
    private int totalNumberOfAttempts;

    public BridgeGame() {
        this.numberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(numberGenerator);
        this.count = COUNT_INITIAL_VALUE;
        this.totalNumberOfAttempts = ATTEMPTS_INITIAL_VALUE;
    }

    public void setBridge(int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public int getCount() {
        return count;
    }

    public int getTotalNumberOfAttempts() {
        return totalNumberOfAttempts;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (bridge.get(count).equals(moving)) {
            count++;
            return true;
        }
        count++;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        count = COUNT_INITIAL_VALUE;
        if (gameCommand.equals(KeyboardCommand.RESTART.getCommand())) {
            totalNumberOfAttempts++;
            return true;
        }
        return false;
    }

    public boolean isGameContinue() {
        if (bridge.size() > count) {
            return true;
        }
        return false;
    }
}
