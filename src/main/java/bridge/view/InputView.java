package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.view.InputViewString.*;

public class InputView {
    public void startMessage(){
        System.out.println(START_MESSAGE);
    }

    public int inputBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String input = Console.readLine();
        checkEmpty(input);
        return checkAndConvertToInt(input);
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
