package bridge.controller;

import bridge.Constants;
import bridge.view.InputView;
import java.util.Arrays;
import java.util.List;

public class InputController {
    private static InputView inputView = new InputView();

//    public InputController(InputView inputView) {
//        this.inputView = inputView;
//    }

    private static List<Integer> recursions = Arrays.asList(1, 1, 1);

    public static int setBridgeSize() {
        try {
            System.out.println(Constants.GameProcessMessages.INPUT_BRIDGE_LENGTH);
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(Constants.GameElements.RECURSION_SET_BRIDGE_SIZE)) return 0;
            System.out.println(ie.getMessage());
            return setBridgeSize();
        }
    }

    public static String setMoveChoice() {
        try{
            System.out.println(Constants.GameProcessMessages.INPUT_WHERETO_MOVE);
            return inputView.readMoving();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(Constants.GameElements.RECURSION_SET_MOVE_CHOICE)) return "end";
            System.out.println(ie.getMessage());
            return setMoveChoice();
        }
    }

    public static String setGameCommand() {
        try {
            System.out.println(Constants.GameProcessMessages.INPUT_RETRY_ORNOT);
            return inputView.readGameCommand();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(Constants.GameElements.RECURSION_SET_GAME_COMMAND)) return "end";
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
            if (recursions.get(i) > Constants.GameElements.MAX_RECURSION) {
                return true;
            }
        }
        return false;
    }

    public static void init() {
        recursions = Arrays.asList(1, 1, 1);
    }
}
