package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.validator.InputRetryOrExitValidator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RETRY = InputRetryOrExitValidator.RETRY;

    private final Bridge bridge;
    private final int bridgeSize;
    private final UserPath userPath;
    private int userPosition;
    private int tryNumber;

    public BridgeGame(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
        this.bridgeSize = size;
        this.userPath = new UserPath();
        this.userPosition = 0;
        this.tryNumber = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movement) {
        boolean isPass = bridge.compareWithPosition(userPosition, movement);

        userPath.move(movement);
        userPosition++;

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
            userPosition = 0;
            userPath.initialize();
            return true;
        }
        return false;
    }

    public boolean checkSuccess() {
        if (userPosition == bridgeSize)
            return true;
        return false;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public UserPath getUserPath() {
        return userPath;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
