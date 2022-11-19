package bridge.view;

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(Validation validation) {
        String bridgeSize = validatedUserInput(validation);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(Validation validation) {
        return validatedUserInput(validation);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Validation validation) {
        return validatedUserInput(validation);
    }

    private String validatedUserInput(Validation validation){
        String input = userInput();
        validate(input, validation);
        return input;
    }

    private void validate(String input, Validation validation){
        validation.validate(input);
    }

    private String userInput(){
        return Console.readLine();
    }
}
