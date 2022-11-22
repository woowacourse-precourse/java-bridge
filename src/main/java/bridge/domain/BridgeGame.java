package bridge.domain;

import bridge.BridgeMaker;
import bridge.validator.InputRetryOrExitValidator;

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

    public boolean move(String movement) {
        boolean isPass = bridge.compareWithPosition(userPath.size(), movement);

        userPath.move(movement);

        if (isPass && userPath.size() == bridge.size()) {
            success = true;
        }

        return isPass;
    }

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
