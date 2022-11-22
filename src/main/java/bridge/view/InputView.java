package bridge.view;

import bridge.setting.Setting;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    // 다리 길이 입력받는 기능
    public int readBridgeSize() {
        String input = Console.readLine();
        checkEmpty(input);
        checkIsNumber(input);
        checkDigit(input);
        validateBridgeRange(input);
        return Integer.parseInt(input);
    }

    // 공백을 입력한 경우 예외처리
    private void checkEmpty(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

    // 숫자가 아닐경우 예외처리
    private void checkIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해야 합니다.");
            }
        }
    }

    // 2자리를 넘어선 문자열인 경우 예외처리
    private void checkDigit(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해야 합니다.");
        }
    }

    // 3이상 20이하의 숫자가 아닐경우 예외처리
    private void validateBridgeRange(String input) {
        int range = Integer.parseInt(input);
        if (range > Setting.MAX_BRIDGE_SIZE || range < Setting.MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해야 합니다.");
        }
    }

    // 이동할 칸을 입력받는 기능
    public String readMoving() {
        String input = Console.readLine();
        checkEmpty(input);
        validateMoveInput(input);
        return input;
    }

    // U키, D키 외에 다른 키 입력받았는지 검증하는 기능
    private void validateMoveInput(String input) {
        if (!(input.equals(Setting.MOVE_UP_KEY) || input.equals(Setting.MOVE_DOWN_KEY))) {
            throw new IllegalArgumentException("[ERROR] 'U'키와 'D'키 만 입력 가능합니다.");
        }
    }

    // 게임을 다시 시도할지 종료할지 여부를 입력받는 기능
    public String readGameCommand() {
        String input = Console.readLine();
        checkEmpty(input);
        validateRetryInput(input);
        return input;
    }

    // R키, Q키 외에 다른 키 입력받았는지 검증하는 기능
    private void validateRetryInput(String input) {
        if (!(input.equals(Setting.RETRY_BUTTON) || input.equals(Setting.EXIT_BUTTON))) {
            throw new IllegalArgumentException("[ERROR] 'R'키와 'Q'키 만 입력 가능합니다.");
        }
    }
}
