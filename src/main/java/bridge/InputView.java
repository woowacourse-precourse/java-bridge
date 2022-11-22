package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ValidateError validateError = new ValidateError();

    /**
     * 다리의 길이를 입력받는다. -> bridgemaker
     */

    public int readBridgeSize() {
        String userInput;
        while (true) {
            System.out.println(printOutput.INPUT_BRIDGE_SIZE.getGameOutput());
            try {
                userInput = readLine();
                validateError.validIsNumber(userInput);
                validateError.validIsInRange(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(userInput);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput ;
        while (true) {
            try {
                userInput = readLine();
                validateError.validIsNotSuitableMovingCommand(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput;
        while (true) {
            System.out.println(printOutput.RESTART_OR_QUIT.getGameOutput());
            try {
                userInput = readLine();
                validateError.validIsNotSuitableEndCommand(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userInput;
    }
}
