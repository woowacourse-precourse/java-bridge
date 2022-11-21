package model;

import constant.NumberConstant;
import controller.BridgeController;
import java.util.ArrayList;
import java.util.List;
import util.validator.BridgeGameValidator;
import util.CleanerUtil;

public class BridgeGame {
    private static final int firstIndex = NumberConstant.FIRST_INDEX.getConstant();
    private static int tryNumber = NumberConstant.FIRST_TRY.getConstant();
    private static List<String> userBridge;

    public BridgeGame(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public static int getTryNumber() {
        return tryNumber;
    }

    public static void move(List<String> bridge, List<List<String>> bothSide) {
        initUserBridge();
        for (int index = firstIndex; index < bridge.size(); index++) {
            addMoveInUserBridge();
            isUserPathEqualsPath(bothSide, bridge, index);
            if (BridgeGameValidator.isMoveDone(bridge, bothSide)) {
                break;
            }
        }
        checkRetry(bridge, bothSide);
    }

    public static void retry(List<String> bridge, List<List<String>> bothSide) {
        String retryOrQuit = BridgeController.getGameCommand();
        BridgeController.printRetryOrQuit(retryOrQuit);
        if (BridgeGameValidator.isUserInputRetry(retryOrQuit)) {
            tryNumber++;
            CleanerUtil.clearBothSide(bothSide);
            move(bridge, bothSide);
        }
    }

    public static void cleanTryNumber() {
        tryNumber = NumberConstant.FIRST_TRY.getConstant();
    }

    public static void initUserBridge() {
        userBridge = new ArrayList<>();
    }

    private static void addMoveInUserBridge() {
        userBridge.add(BridgeController.getMoving());
    }

    private static void isUserPathEqualsPath(List<List<String>> bothSide, List<String> bridge, int index) {
        if (userBridge.get(index).equals(bridge.get(index))) {
            addCorrectPath(bothSide, bridge, index);
            return;
        }
        if (!userBridge.get(index).equals(bridge.get(index))) {
            addWrongPath(bothSide, bridge, index);
        }
    }

    private static void addCorrectPath(List<List<String>> bothSide, List<String> bridge, int index) {
        if (BridgeGameValidator.isBridgeEqualsU(bridge.get(index))) {
            BothSide.addCorrectPathUpSide(bothSide);
        }
        if (BridgeGameValidator.isBridgeEqualsD(bridge.get(index))) {
            BothSide.addCorrectPathDownSide(bothSide);
        }
        printMoving(bothSide, userBridge.get(index));
    }

    private static void addWrongPath(List<List<String>> bothSide, List<String> bridge, int index) {
        if (BridgeGameValidator.isBridgeEqualsU(bridge.get(index))) {
            BothSide.addWrongPathDownSide(bothSide);
        }
        if (BridgeGameValidator.isBridgeEqualsD(bridge.get(index))) {
            BothSide.addWrongPathUpSide(bothSide);
        }
        printMoving(bothSide, userBridge.get(index));
    }

    private static void checkRetry(List<String> bridge, List<List<String>> bothSide) {
        if (BridgeGameValidator.isContainWrongPath(bothSide)) {
            retry(bridge, bothSide);
        }
    }

    private static void printMoving(List<List<String>> bothSide, String userPath) {
        BridgeController.printMoving(userPath);
        BridgeController.printMap(bothSide);
    }
}
