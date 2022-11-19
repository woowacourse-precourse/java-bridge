package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validator validator = new Validator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        BridgeGame bridgeGame = new BridgeGame();
        String userInput = "";
        while (true) {
            bridgeGame.printRequestBridgeSizeMessage();
            try {
                userInput = readLine();
                validator.validIsNum(userInput);
                validator.validRange(userInput);
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
        String userInput = "";
        while (true) {
            try {
                 userInput = readLine();
                validator.validMovingInput(userInput);
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
        BridgeGame bridgeGame = new BridgeGame();
        String userInput = "";
        while (true) {
            bridgeGame.printRequestRetryMessage();
            try {
                userInput = readLine();
                validator.validGameCommandInput(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userInput;
    }
}
