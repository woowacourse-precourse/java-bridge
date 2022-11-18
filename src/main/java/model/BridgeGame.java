package model;

import constant.GameConstant;
import controller.BridgeController;
import constant.StringConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {
    private static int tryNumber = GameConstant.FIRST_TRY.getConstant();
    private static int bridgeNumber = GameConstant.FIRST_INDEX.getConstant();

    public void run() {
        List<String> upSide = new ArrayList<>();
        List<String> downSide = new ArrayList<>();
        List<String> bridge = BridgeController.makeBridge();
        checkNextPath(bridge, upSide, downSide);
    }

    public List<String> move(List<String> bridge, String path) {
        BridgeController.printMoving(path);
        List<String> bridgeByUser = new ArrayList<>();
        addPathInBridgeByUser(bridge, bridgeByUser, path);
        countBridgeNumber();
        return Collections.unmodifiableList(bridgeByUser);
    }

    public void retry(List<String> bridge, List<String> upSide, List<String> downSide) {
        String retryOrQuit = BridgeController.getGameCommand();
        BridgeController.printRetryOrQuit(retryOrQuit);
        if (isUserInputRetry(retryOrQuit)) {
            countTryNumber();
            checkNextPath(bridge, upSide, downSide);
        }
        if (isUserInputQuit(retryOrQuit)) {
            BridgeController.printResult(upSide, downSide, tryNumber);
        }
    }

    private void addPathInBridgeByUser(List<String> bridge, List<String> bridgeByUser, String path) {
        if (isUserPathEqualsBridge(bridge, path)) {
            addCorrectPath(bridgeByUser, path);
        }
        if (!isUserPathEqualsBridge(bridge, path)) {
            addWrongPath(bridgeByUser, path);
        }
    }

    private void addCorrectPath(List<String> isCorrectBridge, String path) {
        isCorrectBridge.add(path);
        isCorrectBridge.add(StringConstant.CORRECT_PATH.getConstant());
    }

    private void addWrongPath(List<String> isCorrectBridge, String path) {
        isCorrectBridge.add(path);
        isCorrectBridge.add(StringConstant.WRONG_PATH.getConstant());
    }

    private boolean isUserPathEqualsBridge(List<String> bridge, String path) {
        return bridge.get(bridgeNumber).equals(path);
    }

    private void checkNextPath(List<String> bridge, List<String> upSide, List<String> downSide) {
        addCorrectResult(bridge, upSide, downSide);
        addWrongResult(bridge, upSide, downSide);
        if (isUserInputDone(bridge, upSide, downSide)) {
            return;
        }
        checkNextPath(bridge, upSide, downSide);
    }

    private void addCorrectResult(List<String> bridge, List<String> upSide, List<String> downSide) {
        while (!isUserInputDone(bridge, upSide)) {
            addCorrectSymbolUpSideDownSide(bridge, upSide, downSide);
        }
    }

    private void addWrongResult(List<String> bridge, List<String> upSide, List<String> downSide) {
        while (!isUserInputDone(bridge, upSide)) {
            addWrongSymbolUpSideDownSide(bridge, upSide, downSide);
        }
    }

    private boolean isUserInputDone(List<String> bridge, List<String> upSide, List<String> downSide) {
        if (isUserInputDone(bridge, upSide)) {
            BridgeController.printResult(upSide, downSide, tryNumber);
            return true;
        }
        return false;
    }

    private void addCorrectSymbolUpSideDownSide(List<String> bridge, List<String> upSide, List<String> downSide) {
        List<String> userMove = getUserMove(bridge);
        if (userMoveEqualsU(userMove) && userMoveCorrect(userMove)) {
            upSide.add(StringConstant.CORRECT_PATH.getConstant());
            downSide.add(StringConstant.BLANK.getConstant());
        }
        if (userMoveEqualsD(userMove) && userMoveCorrect(userMove)) {
            upSide.add(StringConstant.BLANK.getConstant());
            downSide.add(StringConstant.CORRECT_PATH.getConstant());
        }
        BridgeController.printMap(upSide, downSide);
    }

    private void addWrongSymbolUpSideDownSide(List<String> bridge, List<String> upSide, List<String> downSide) {
        List<String> userMove = getUserMove(bridge);
        if (userMoveEqualsU(userMove) && userMoveWrong(userMove)) {
            upSide.add(StringConstant.WRONG_PATH.getConstant());
            downSide.add(StringConstant.BLANK.getConstant());
        }
        if (userMoveEqualsD(userMove) && userMoveWrong(userMove)) {
            upSide.add(StringConstant.BLANK.getConstant());
            downSide.add(StringConstant.WRONG_PATH.getConstant());
        }
        BridgeController.printMap(upSide, downSide);
        retry(bridge, upSide, downSide);
    }

    private boolean isUserInputDone(List<String> bridge, List<String> upSide) {
        return bridge.size() == upSide.size();
    }

    private boolean userMoveEqualsU(List<String> userMove) {
        return userMove.get(GameConstant.FIRST_INDEX.getConstant()).equals(StringConstant.UP_SIDE.getConstant());
    }

    private boolean userMoveEqualsD(List<String> userMove) {
        return userMove.get(GameConstant.FIRST_INDEX.getConstant()).equals(StringConstant.DOWN_SIDE.getConstant());
    }

    private boolean userMoveCorrect(List<String> userMove) {
        return userMove.get(GameConstant.SECOND_INDEX.getConstant()).equals(StringConstant.CORRECT_PATH.getConstant());
    }

    private boolean userMoveWrong(List<String> userMove) {
        return userMove.get(GameConstant.SECOND_INDEX.getConstant()).equals(StringConstant.WRONG_PATH.getConstant());
    }

    private List<String> getUserMove(List<String> bridge) {
        return move(bridge, BridgeController.getMoving());
    }

    private boolean isUserInputRetry(String retryOrQuit) {
        return retryOrQuit.equals(StringConstant.RETRY.getConstant());
    }

    private boolean isUserInputQuit(String retryOrQuit) {
        return retryOrQuit.equals(StringConstant.QUIT.getConstant());
    }

    private void countBridgeNumber() {
        bridgeNumber++;
    }

    private void countTryNumber() {
        tryNumber++;
    }
}
