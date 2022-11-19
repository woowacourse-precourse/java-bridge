package bridge.controller;

import bridge.view.InputView;

public class InputController {
    public static int setBridgeSize() {
        try {
            System.out.println("Please input length of bridge");
            int length = InputView.readBridgeSize();
            return length;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return setBridgeSize();
        }
    }

    public static String setMoveChoice() {
        try{
            System.out.println("choice where to move");
            String choice = InputView.readMoving();
            return choice;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return setMoveChoice();
        }
    }

    public static String setGameCommand() {
        try {
            System.out.println("please decide to try again");
            String retryChoice = InputView.readGameCommand();
            return retryChoice;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return setGameCommand();
        }
    }
}
