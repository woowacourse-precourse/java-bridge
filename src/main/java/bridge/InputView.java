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
    public int readBridgeSize() {
        bridgeGame.printInputBridgeSize();
        String userInput = readLine();
        validateError.validIsNumber(userInput);
        validateError.validIsInRange(userInput);

        return Integer.parseInt(userInput);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        bridgeGame.printSelectBridgeUpDown();
        String userInput = readLine();
        validateError.validIsNotSuitableMovingCommand(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        bridgeGame.printRestartOrQuit();
        String userInput = readLine();
        validateError.validIsNotSuitableEndCommand(userInput);
        return userInput;
    }
}
