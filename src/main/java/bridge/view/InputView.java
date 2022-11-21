package bridge.view;

import bridge.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final ValidationUtil validationUtil;

    public InputView() {
        validationUtil = new ValidationUtil();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeLength() {
        String bridgeLength = Console.readLine();
        try {
            return validationUtil.validateBridgeLength(bridgeLength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeLength();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String playerMove = Console.readLine();
        try {
            return validationUtil.validatePlayerMoveInput(playerMove);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        try {
            return validationUtil.validatePlayControlInput(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
