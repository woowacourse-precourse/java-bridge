package bridge.view;

import bridge.controller.InputViewException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료:  Q)";

    InputViewException inputViewException;
    private String input;


    public InputView() {
        inputViewException = new InputViewException();
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(START_MESSAGE);
        do {
            System.out.println(BRIDGE_SIZE_MESSAGE);
            input = Console.readLine().trim();
        } while (this.bridgeSizeTryCatch(input));
        return Integer.parseInt(input);
    }

    public boolean bridgeSizeTryCatch(String str) {
        try {
            inputViewException.readBridgeSizeException(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            return true;
        }
        return false;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        do {
            System.out.println(MOVE_MESSAGE);
            input = Console.readLine().trim();
        } while (this.movingTryCatch(input));
        return input;
    }

    public boolean movingTryCatch(String str) {
        try {
            inputViewException.readMovingException(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        do {
            System.out.println(COMMAND_MESSAGE);
            input = Console.readLine().trim();
        } while (this.gameCommandTryCatch(input));
        return input;
    }

    public boolean gameCommandTryCatch(String str) {
        try {
            inputViewException.readGameCommandException(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            return true;
        }
        return false;
    }
}
