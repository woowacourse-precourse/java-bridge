package bridge.controller;

import bridge.view.InputView;
import java.util.Arrays;
import java.util.List;

public class InputController {
    private final static int MAX_RECURSION = 1000;
    private final static List<Integer> recursions = Arrays.asList(1, 1, 1);

    public static int setBridgeSize() {
        try {
            System.out.println("Please input length of bridge");
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(0)) return 0;
            System.out.println(ie.getMessage());
            return setBridgeSize();
        }
    }

    public static String setMoveChoice() {
        try{
            System.out.println("choice where to move");
            return InputView.readMoving();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(1)) return "end";
            System.out.println(ie.getMessage());
            return setMoveChoice();
        }
    }

    public static String setGameCommand() {
        try {
            System.out.println("please decide to try again");
            return InputView.readGameCommand();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(2)) return "end";
            System.out.println(ie.getMessage());
            return setGameCommand();
        }
    }

    private static boolean checkMaxRecursion(int whichOne) {
        Integer recursionCount = recursions.get(whichOne);
        recursions.set(whichOne, recursionCount+1);
        return checkIfRecursionExceed();
    }

    private static boolean checkIfRecursionExceed() {
        for (int i=0; i<recursions.size(); i++) {
            if (recursions.get(i) > MAX_RECURSION) {
                return true;
            }
        }
        return false;
    }
}
