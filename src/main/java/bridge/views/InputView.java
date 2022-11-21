package bridge.views;

import bridge.exceptions.CustomIllegalArgumentException;
import bridge.exceptions.CustomIllegalStateException;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends DefaultView {

    private static final String MSG_REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MSG_REQUEST_MOVING_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MSG_REQUEST_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String FORMAT_ONLY_ALPHABET = "^[a-zA-Z]+$";
    private static final String FORMAT_ONLY_NUMBER = "^[0-9]+$";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        output(MSG_REQUEST_BRIDGE_SIZE);
        String input = input();
        validateBridgeSize(input);
        printLineSeparator();
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        validateOnlyNumber(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        output(MSG_REQUEST_MOVING_DIRECTION);
        String input = input();
        validateMovingDirection(input);
        return input;
    }

    private void validateMovingDirection(String input) {
        validateOnlyAlphabet(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        output(MSG_REQUEST_GAME_COMMAND);
        String input = input();
        validateGameCommand(input);
        return input;
    }

    private void validateGameCommand(String input) {
        validateOnlyAlphabet(input);
    }

    private void validateOnlyAlphabet(String input) {
        if (!Pattern.matches(FORMAT_ONLY_ALPHABET, input))
            throw new CustomIllegalArgumentException(
                    "알파벳만 입력해야 합니다."
            );
    }

    private void validateOnlyNumber(String input){
        if (!Pattern.matches(FORMAT_ONLY_NUMBER, input))
            throw new CustomIllegalArgumentException(
                    "0 이상의 정수만 입력해야 합니다."
            );
    }
}
