package bridge.controller;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private InputValidation inputValidation;

    public Input() {
        this.inputValidation = new InputValidation();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();
        inputValidation.bridgeSize(userInput);
        return Integer.valueOf(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = Console.readLine();
        inputValidation.userMove(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = Console.readLine();
        inputValidation.restartOrEnd(userInput);
        return userInput;
    }
}
