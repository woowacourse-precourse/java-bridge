package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String START_GAME_MSG = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_LENGTH_OF_BRIDGE_MSG = "다리의 길이를 입력해주세요.";

    private String getInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException();
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(START_GAME_MSG);
        System.out.println(INPUT_LENGTH_OF_BRIDGE_MSG);

        return convertStringToInteger(validateBridgeSize(getInput()));
    }

    private int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }

    private String validateBridgeSize(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
