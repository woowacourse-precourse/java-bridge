package bridge.exception;

import bridge.view.InputView;

public class InputException {
    public static int validateBridgeSize(String input) {
        try {
            int size = convertToNumber(input);
            accurateRange(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateBridgeSize(InputView.readBridgeSize());
        }
    }

    private static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionPhrases.BridgeSizeNumber.getPhrase());
        }
    }

    private static void accurateRange(int size) {
        if(!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException(ExceptionPhrases.BridgeSizeRange.getPhrase());
        }
    }

    public static String validateMovingValue(String input) {
        try {
            accurateValue(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateMovingValue(InputView.readMoving());
        }
    }

    private static void accurateValue(String value) {
        if(!(value.equals("U") || value.equals("D"))) {
            throw new IllegalArgumentException(ExceptionPhrases.MovingValue.getPhrase());
        }
    }

    public static String validateGameCommand(String command) {
        try {
            accurateCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return validateGameCommand(InputView.readGameCommand());
        }
    }

    private static void accurateCommand(String command) {
        if(!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException(ExceptionPhrases.GameCommand.getPhrase());
        }
    }
 }
