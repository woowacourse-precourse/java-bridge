package bridge.view;

import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeLength() {
        String userInput = getUserInput();
        int bridgeLength = stringToInt(userInput);
        Validator.validateBridgeLength(bridgeLength);
        return bridgeLength;
    }

    public String readMoving() {
        String userInput = getUserInput();
        Validator.validateStringIsEnglish(userInput);
        Validator.validateMovingType(userInput);
        return userInput.toUpperCase();
    }

    public String readGameCommand() {
        String userInput = getUserInput();
        Validator.validateStringIsEnglish(userInput);
        Validator.validateRestartOption(userInput);
        return userInput.toUpperCase();
    }

    private String getUserInput(){
        return Console.readLine();
    }

    private int stringToInt(String input){
        Validator.validateStringIsNumeric(input);
        return Integer.parseInt(input);
    }
}
