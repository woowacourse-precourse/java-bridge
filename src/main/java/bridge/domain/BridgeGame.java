package bridge.domain;

import bridge.BridgeMaker;
import bridge.validator.InputRetryOrExitValidator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RETRY = InputRetryOrExitValidator.RETRY;

    private final Bridge bridge;
    private final UserPath userPath;
    private int tryNumber;
    private boolean success;

    public BridgeGame(int size, BridgeMaker bridgeMaker) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
        this.userPath = new UserPath();

        initialize();
    }

    private void initialize() {
        this.tryNumber = 1;
        this.success = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movement) {
        boolean isPass = bridge.compareWithPosition(userPath.size(), movement);

        userPath.move(movement);

        if (isPass && userPath.size() == bridge.size()) {
            success = true;
        }

        return isPass;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals(RETRY)) {
            tryNumber++;
            userPath.initialize();
            return true;
        }
        return false;
    }

    public boolean checkSuccess() {
        return success;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public UserPath getUserPath() {
        return userPath;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
