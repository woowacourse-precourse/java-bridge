package bridge.UI;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.Constants.FrontMan;
import bridge.Constants.ErrorMessages;
import java.util.Objects;

public class InputView {

    public int readBridgeLength() {
        System.out.println(FrontMan.INPUT_BRIDGE_LENGTH);
        String userInput = readLine();
        validateBridgeLength(userInput);
        return Integer.parseInt(userInput);
    }

    public void validateBridgeLength(String userInput) {
        if (Objects.equals(userInput, ErrorMessages.NULL) || !userInput.matches(
                ErrorMessages.ONLY_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.SHOULD_ENTER_NUMBER);
        }
        if (Integer.parseInt(userInput) < 3 || Integer.parseInt(userInput) > 20) {
            throw new IllegalArgumentException(
                    ErrorMessages.BRIDGE_LENGTH_SHOULD_BE_NUMBER_BETWEEN_3_AND_20);
        }
    }

    public String readMoving() {
        System.out.println(FrontMan.CHOOSE_NEXT_STEP);
        String userInput = readLine();
        validateNextStep(userInput);
        return userInput;
    }

    public void validateNextStep(String userInput) {
        if (!Objects.equals(userInput, "U") && !Objects.equals(userInput, "D")) {
            throw new IllegalArgumentException(ErrorMessages.SHOULD_MOVE_TO_UPSIZE_OR_DOWN_SIZE);
        }
    }

    public String readGameCommand() {
        
    }
}
