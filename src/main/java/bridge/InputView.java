package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    BridgeGame bridgeGame = new BridgeGame();
    ValidateError validateError = new ValidateError();

    /**
     * 다리의 길이를 입력받는다. -> bridgemaker
     */

    public String userInput() {
        return readLine();
    }

    public int readBridgeSize(String userInput) {
        bridgeGame.printInputBridgeSize();
        validateError.validIsNumber(userInput);
        validateError.validIsInRange(userInput);
        return Integer.parseInt(userInput);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String userInput) {
        bridgeGame.printSelectBridgeUpDown();
        validateError.validIsNotSuitableMovingCommand(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String userInput) {
        bridgeGame.printRestartOrQuit();
        validateError.validIsNotSuitableEndCommand(userInput);
        return userInput;
    }
}
