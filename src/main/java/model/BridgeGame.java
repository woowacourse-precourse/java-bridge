package model;

import constant.Number;
import controller.BridgeController;
import constant.StringConstant;
import domain.BridgeSize;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    public static int tryNumber = Number.FIRST_TRY.getNumber();
    private static List<String> userBridge;

    public static void move(List<String> bridge, List<List<String>> bothSide) {
        userBridge = new ArrayList<>();
        addMoveInUserBridge(userBridge);
        for (int i = 0; i < userBridge.size(); i++) {
            isUserPathEqualsPath(bothSide, bridge, i);
            if (BridgeSize.isUserInputDone(bridge, bothSide) || isContainWrongPath(bothSide)) {
                break;
            }
            addMoveInUserBridge(userBridge);
        }
    }

    public static void retry(List<String> bridge, List<List<String>> bothSide) {
        String retryOrQuit = BridgeController.getGameCommand();
        BridgeController.printRetryOrQuit(retryOrQuit);
        if (isUserInputRetry(retryOrQuit)) {
            countTryNumber();
            clearbothSide(bothSide);
            move(bridge, bothSide);
        }
    }

    public static void addMoveInUserBridge(List<String> userBridge) {
        userBridge.add(BridgeController.getMoving());
    }

    public static void checkRetry(List<String> bridge, List<List<String>> bothSide) {
        if (isContainWrongPath(bothSide)) {
            retry(bridge, bothSide);
        }
    }

    public static boolean isContainWrongPath(List<List<String>> bothSide) {
        return bothSide.get(Number.UP_SIDE.getNumber()).contains(StringConstant.WRONG_PATH.getConstant())
                || bothSide.get(Number.DOWN_SIDE.getNumber()).contains(StringConstant.WRONG_PATH.getConstant());
    }

    public static void clearTryNumber() {
        tryNumber = Number.FIRST_TRY.getNumber();
    }

    private static void clearbothSide(List<List<String>> bothSide) {
        bothSide.get(Number.UP_SIDE.getNumber()).clear();
        bothSide.get(Number.DOWN_SIDE.getNumber()).clear();
    }


    private static void printMoving(List<List<String>> bothSide, String userPath) {
        BridgeController.printMoving(userPath);
        BridgeController.printMap(bothSide);
    }

    private static void isUserPathEqualsPath(List<List<String>> bothSide, List<String> bridge, int i) {
        if (userBridge.get(i).equals(bridge.get(i))) {
            addCorrectPath(bothSide, bridge, i);
            return;
        }
        if (!userBridge.get(i).equals(bridge.get(i))) {
            addWrongPath(bothSide, bridge, i);
        }
    }

    private static void addWrongPath(List<List<String>> bothSide, List<String> bridge, int i) {
        if (isBridgeEqualsU(bridge.get(i))) {
            addWrongPathDownSide(bothSide);
        }
        if (isBridgeEqualsD(bridge.get(i))) {
            addWrongPathUpSide(bothSide);
        }
        printMoving(bothSide, userBridge.get(i));
        checkRetry(bridge, bothSide);
    }

    private static void addCorrectPath(List<List<String>> bothSide, List<String> bridge, int i) {
        if (isBridgeEqualsU(bridge.get(i))) {
            addCorrectPathUpSide(bothSide);
        }
        if (isBridgeEqualsD(bridge.get(i))) {
            addCorrectPathDownSide(bothSide);
        }
        printMoving(bothSide, userBridge.get(i));
    }

    private static boolean isBridgeEqualsD(String bridgeIndex) {
        return bridgeIndex.equals(StringConstant.DOWN_SIDE.getConstant());
    }

    private static boolean isBridgeEqualsU(String bridgeIndex) {
        return bridgeIndex.equals(StringConstant.UP_SIDE.getConstant());
    }

    private static void addWrongPathDownSide(List<List<String>> bothSide) {
        bothSide.get(Number.UP_SIDE.getNumber()).add(StringConstant.BLANK.getConstant());
        bothSide.get(Number.DOWN_SIDE.getNumber()).add(StringConstant.WRONG_PATH.getConstant());
    }

    private static void addWrongPathUpSide(List<List<String>> bothSide) {
        bothSide.get(Number.UP_SIDE.getNumber()).add(StringConstant.WRONG_PATH.getConstant());
        bothSide.get(Number.DOWN_SIDE.getNumber()).add(StringConstant.BLANK.getConstant());
    }

    private static void addCorrectPathDownSide(List<List<String>> bothSide) {
        bothSide.get(Number.UP_SIDE.getNumber()).add(StringConstant.BLANK.getConstant());
        bothSide.get(Number.DOWN_SIDE.getNumber()).add(StringConstant.CORRECT_PATH.getConstant());
    }

    private static void addCorrectPathUpSide(List<List<String>> bothSide) {
        bothSide.get(Number.UP_SIDE.getNumber()).add(StringConstant.CORRECT_PATH.getConstant());
        bothSide.get(Number.DOWN_SIDE.getNumber()).add(StringConstant.BLANK.getConstant());
    }

    private static boolean isUserInputRetry(String retryOrQuit) {
        return retryOrQuit.equals(StringConstant.RETRY.getConstant());
    }

    private static void countTryNumber() {
        tryNumber++;
    }
}