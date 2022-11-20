package model;

import constant.NumberConstant;
import controller.BridgeController;
import constant.StringConstant;
import domain.BridgeSize;
import java.util.ArrayList;
import java.util.List;
import util.BridgeGameValidator;

public class BridgeGame {
    public static int tryNumber = NumberConstant.FIRST_TRY.getConstant();
    private static List<String> userBridge;

    public static void move(List<String> bridge, List<List<String>> bothSide) {
        int firstIndex = NumberConstant.FIRST_INDEX.getConstant();
        userBridge = new ArrayList<>();
        addMoveInUserBridge();
        for (int index = firstIndex; index < userBridge.size(); index++) {
            isUserPathEqualsPath(bothSide, bridge, index);
            if (BridgeSize.isUserInputDone(bridge, bothSide) || BridgeGameValidator.isContainWrongPath(bothSide)) {
                break;
            }
            addMoveInUserBridge();
        }
    }

    public static void retry(List<String> bridge, List<List<String>> bothSide) {
        String retryOrQuit = BridgeController.getGameCommand();
        BridgeController.printRetryOrQuit(retryOrQuit);
        if (BridgeGameValidator.isUserInputRetry(retryOrQuit)) {
            countTryNumber();
            clearbothSide(bothSide);
            move(bridge, bothSide);
        }
    }

    public static void addMoveInUserBridge() {
        userBridge.add(BridgeController.getMoving());
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

    private static void addCorrectPath(List<List<String>> bothSide, List<String> bridge, int i) {
        if (BridgeGameValidator.isBridgeEqualsU(bridge.get(i))) {
            addCorrectPathUpSide(bothSide);
        }
        if (BridgeGameValidator.isBridgeEqualsD(bridge.get(i))) {
            addCorrectPathDownSide(bothSide);
        }
        printMoving(bothSide, userBridge.get(i));
    }

    private static void addWrongPath(List<List<String>> bothSide, List<String> bridge, int i) {
        if (BridgeGameValidator.isBridgeEqualsU(bridge.get(i))) {
            addWrongPathDownSide(bothSide);
        }
        if (BridgeGameValidator.isBridgeEqualsD(bridge.get(i))) {
            addWrongPathUpSide(bothSide);
        }
        printMoving(bothSide, userBridge.get(i));
        checkRetry(bridge, bothSide);
    }

    private static void addWrongPathDownSide(List<List<String>> bothSide) {
        bothSide.get(NumberConstant.UP_SIDE.getConstant()).add(StringConstant.BLANK.getConstant());
        bothSide.get(NumberConstant.DOWN_SIDE.getConstant()).add(StringConstant.WRONG_PATH.getConstant());
    }

    private static void addWrongPathUpSide(List<List<String>> bothSide) {
        bothSide.get(NumberConstant.UP_SIDE.getConstant()).add(StringConstant.WRONG_PATH.getConstant());
        bothSide.get(NumberConstant.DOWN_SIDE.getConstant()).add(StringConstant.BLANK.getConstant());
    }

    private static void addCorrectPathDownSide(List<List<String>> bothSide) {
        bothSide.get(NumberConstant.UP_SIDE.getConstant()).add(StringConstant.BLANK.getConstant());
        bothSide.get(NumberConstant.DOWN_SIDE.getConstant()).add(StringConstant.CORRECT_PATH.getConstant());
    }

    private static void addCorrectPathUpSide(List<List<String>> bothSide) {
        bothSide.get(NumberConstant.UP_SIDE.getConstant()).add(StringConstant.CORRECT_PATH.getConstant());
        bothSide.get(NumberConstant.DOWN_SIDE.getConstant()).add(StringConstant.BLANK.getConstant());
    }

    public static void checkRetry(List<String> bridge, List<List<String>> bothSide) {
        if (BridgeGameValidator.isContainWrongPath(bothSide)) {
            retry(bridge, bothSide);
        }
    }

    private static void printMoving(List<List<String>> bothSide, String userPath) {
        BridgeController.printMoving(userPath);
        BridgeController.printMap(bothSide);
    }

    private static void clearbothSide(List<List<String>> bothSide) {
        bothSide.get(NumberConstant.UP_SIDE.getConstant()).clear();
        bothSide.get(NumberConstant.DOWN_SIDE.getConstant()).clear();
    }

    private static void countTryNumber() {
        tryNumber++;
    }

    public static void clearTryNumber() {
        tryNumber = NumberConstant.FIRST_TRY.getConstant();
    }
}
