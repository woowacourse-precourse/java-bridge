package bridge.view;

import bridge.exception.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Validator validator = new Validator();

    public InputView() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = convertInputToInt(Console.readLine());
        validator.validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveMessage = Console.readLine();
        validator.validateMoveMessage(moveMessage);
        return moveMessage;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String commandMessage = Console.readLine();
        validator.validateGameRestartMessage(commandMessage);
        return commandMessage;
    }

    private int convertInputToInt(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException("숫자를 입력해주세요. 입력값 : " + input);
        }
        return Integer.parseInt(input);
    }

    private boolean isNotNumber(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
