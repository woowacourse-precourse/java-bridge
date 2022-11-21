package bridge.view;

import bridge.util.BridgeSize;
import bridge.util.ExceptionPhrases;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = readUserInput();
        userInputEmptyException(userInput);
        notNumberException(userInput);

        int userInputNumber = Integer.parseInt(userInput);
        outOfBridgeSizeException(userInputNumber);
        return userInputNumber;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public String readUserInput() {
        return Console.readLine();
    }

    public void userInputEmptyException(String userInput) {
        if (userInput.isEmpty() || userInput.isBlank()) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_EMPTY_INPUT.getPharases());
        }
    }

    public void notNumberException(String userInput) {
        userInput.chars().forEach(eachInput -> {
            if (!isNumber(eachInput)) {
                throw new IllegalArgumentException(ExceptionPhrases.IS_NOT_NUMBER.getPharases());
            }
        });
    }

    public boolean isNumber(int eachInput) {
        return Character.isDigit(eachInput);
    }

    public void outOfBridgeSizeException(int userInput) {
        if (userInput < BridgeSize.BRIDGE_MIN_SIZE.getSize() || userInput > BridgeSize.BRIDGE_MAX_SIZE.getSize()) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_OUT_OF_SIZE.getPharases());
        }
    }


}
