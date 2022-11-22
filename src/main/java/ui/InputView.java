package ui;

import camp.nextstep.edu.missionutils.Console;
import validation.InputValidation;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidation validator = new InputValidation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = "";
        try {
            System.out.println("다리 길이를 입력해주세요.");
            bridgeSize = Console.readLine();
            validator.validateBridgeSize(bridgeSize);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            this.readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = "";
        try {
            move = Console.readLine();
            validator.validateMoving(move);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = "";
        try {
            gameCommand = Console.readLine();
            validator.validateGameCommand(gameCommand);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return gameCommand;
    }
}
