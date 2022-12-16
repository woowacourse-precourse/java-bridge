package bridge.view;

import bridge.util.ExceptionPhrases;
import bridge.util.OutputPharses;
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
        InputException.userInputEmptyException(userInput);
        InputException.notNumberException(userInput);

        int userInputNumber = Integer.parseInt(userInput);
        InputException.outOfBridgeSizeException(userInputNumber);
        return userInputNumber;
    }


    /**
     * 입력받는 플레이어의 이동 확인 후 예외 발생 시 다시 입력 받는 함수
     */
    public String readMoving() {
        String userInput = readUserInput();
        InputException.userInputEmptyException(userInput);
        InputException.notMoveCommandException(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = readUserInput();
        InputException.userInputEmptyException(userInput);
        InputException.notGameCommandException(userInput);
        return userInput;
    }

    public String readUserInput() {
        return Console.readLine();
    }




}
