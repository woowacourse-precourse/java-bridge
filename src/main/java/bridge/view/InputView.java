package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.msg.ErrorMsg.*;
import static bridge.msg.InputMsg.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static String REGEX = "[0-9]+";
    private String inputSize;
    private String inputMove;
    private String inputRetry;

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        inputSize = Console.readLine();

        sizeValidateHandler();

        return inputSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        inputMove = Console.readLine();

        moveValidateHandler();

        return inputMove;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        inputRetry= Console.readLine();

        commendValidateHandler();

        return inputRetry;
    }

    private void sizeValidateHandler() {
        try {
            validateSize(inputSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }

    private void moveValidateHandler() {
        try {
            validateMove(inputMove);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
    }

    private void commendValidateHandler() {
        try {
            validateCommand(inputRetry);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
    }

    public void validateSize(String inputSize) {
        if (!inputSize.matches(REGEX))
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERR.getMsg());
        if (Integer.valueOf(inputSize) < 3 || Integer.valueOf(inputSize) > 20)
            throw new IllegalArgumentException(BRIDGE_LENGTH_ERR.getMsg());
    }

    public void validateMove(String inputMove) {
        if (!inputMove.equals(UP_MSG.getMsg()) && !inputMove.equals(DOWN_MSG.getMsg()))
            throw new IllegalArgumentException(MOVE_ERR.getMsg());
    }

    public void validateCommand(String restartInput) {
        if (!restartInput.equals(RESTART_MSG.getMsg()) && !restartInput.equals(QUIT_MSG.getMsg()))
            throw new IllegalArgumentException(RESTART_ERR.getMsg());
    }
}
