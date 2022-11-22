package bridge.controller;

import bridge.Constants;
import bridge.view.InputView;
import java.util.Arrays;
import java.util.List;

public class InputController {
    private InputView inputView;

    public InputController(InputView view) {
        this.inputView = view;
    }

    private static List<Integer> recursions = Arrays.asList(1, 1, 1);

    public int setBridgeSize() {
        try {
            System.out.println(Constants.GameProcessMessages.INPUT_BRIDGE_LENGTH);
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(Constants.GameElements.RECURSION_SET_BRIDGE_SIZE)) return 0;
            System.out.println(ie.getMessage());
            return setBridgeSize();
        }
    }

    public String setMoveChoice() {
        try{
            System.out.println(Constants.GameProcessMessages.INPUT_WHERETO_MOVE);
            return inputView.readMoving();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(Constants.GameElements.RECURSION_SET_MOVE_CHOICE)) return "end";
            System.out.println(ie.getMessage());
            return setMoveChoice();
        }
    }

    public String setGameCommand() {
        try {
            System.out.println(Constants.GameProcessMessages.INPUT_RETRY_ORNOT);
            return inputView.readGameCommand();
        } catch (IllegalArgumentException ie) {
            if (checkMaxRecursion(Constants.GameElements.RECURSION_SET_GAME_COMMAND)) return "end";
            System.out.println(ie.getMessage());
            return setGameCommand();
        }
    }

    private boolean checkMaxRecursion(int whichOne) {
        Integer recursionCount = recursions.get(whichOne);
        recursions.set(whichOne, recursionCount+1);
        return checkIfRecursionExceed();
    }

    private boolean checkIfRecursionExceed() {
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
