package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.util.validator.BridgeMakerValidator;
import bridge.util.validator.BridgeMoveValidator;
import bridge.util.validator.BridgeRetryValidator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static int gameCount = 0;
    private static boolean gameClear = false;

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private ComputerBridge computerBridge = new ComputerBridge();
    private UserBridge userBridge = new UserBridge();

    public void createBridge(String length) {
        new BridgeMakerValidator(length);
        computerBridge.setBridge(bridgeMaker.makeBridge(Integer.parseInt(length)));
        gameCount++;
    }

    public void move(String location) {
        new BridgeMoveValidator(location);
        userBridge.addBridge(location);
    }

    public boolean retry(String retryMessage) {
        new BridgeRetryValidator(retryMessage);
        if (retryMessage.equals("Q")) {
            return false;
        }

        gameCount++;
        userBridge = new UserBridge();
        return true;
    }

    public boolean isGameFail() {
        return userBridge.getBridgeLast().equals(computerBridge.getBridgeInfo(userBridge.getBridgeLength() - 1));
    }

    public boolean isGameSuccess() {
        if (computerBridge.isEqual(userBridge.getBridge())) {
            gameClear = true;
            return true;
        }

        return false;
    }

    public ComputerBridge getComputerBridge() {
        return computerBridge;
    }

    public UserBridge getUserBridge() {
        return userBridge;
    }

    public int getGameCount() {
        return gameCount;
    }

    public boolean getGameClear() {
        return gameClear;
    }
}