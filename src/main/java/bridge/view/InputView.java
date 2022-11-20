package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.view.InputViewString.*;

public class InputView {

    public static int inputBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String input = Console.readLine();
        checkEmpty(input);
        return checkAndConvertToInt(input);
    }

    public static String inputMoving() {
        System.out.println(BLANK_TO_MOVE_MESSAGE.toString());
        String input = Console.readLine();
        checkEmpty(input);
        checkAlphabet(input);
        return input;
    }

    public static String inputGameCommand() {
        System.out.println(RETRY_OR_END_MESSAGE.toString());
        String input = Console.readLine();
        checkEmpty(input);
        checkAlphabet(input);
        return input;
    }

    private static void checkEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException(EMPTY_INPUT.toString());
        }
    }

    private static int checkAndConvertToInt(String input){
//        if (!Pattern.matches("[0-9]+", input)){
//            throw new IllegalArgumentException(NO_NUMBER_INPUT.toString());
//        }
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NO_NUMBER_INPUT.toString());
        }
    }

    private static void checkAlphabet(String input){
        String pattern = "[a-zA-Z]+";
        if (!Pattern.matches(pattern, input)){
            throw new IllegalArgumentException(NO_ALPHABET_INPUT.toString());
        }
    }
}
