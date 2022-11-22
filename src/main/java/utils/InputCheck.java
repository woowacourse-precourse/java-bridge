package utils;

import exception.UserInputException;
import view.InputView;

public class InputCheck {

    public static int bridgeSizeValue() {
        while (true) {
            try {
                return InputView.readBridgeSize();
            } catch (UserInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String setMovingValue() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (UserInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String RestartStatusValue() {
        while (true) {
            try {
                return InputView.readGameCommand();
            } catch (UserInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
