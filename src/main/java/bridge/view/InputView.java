package bridge.view;

import static bridge.domain.validation.InputValidator.validateBridgeSize;
import static bridge.domain.validation.InputValidator.validateCorrectValueForGameCommand;
import static bridge.domain.validation.InputValidator.validateCorrectValueForMoving;
import static bridge.domain.validation.InputValidator.validateThisIsNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * TODO 메서드 시그니처(인자, 이름)와 반환 타입 변경 가능
 * TODO 메서드 추가 가능
 */
public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public int bridgeSize() {
        try {
            return number();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return bridgeSize();
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    private int number() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputValue = readLine();
        validateThisIsNumber(inputValue);

        int intValue = Integer.parseInt(inputValue);
        validateBridgeSize(intValue);

        return intValue;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String moveCommands() {
        try {
            return oneStringForMoveCommands();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return moveCommands();
        }
    }

    private String oneStringForMoveCommands() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputValue = readLine();
        validateCorrectValueForMoving(inputValue);

        return inputValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String gameCommand() {
        try {
            return oneStringForGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return gameCommand();
        }
    }

    private String oneStringForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputValue = readLine();
        validateCorrectValueForGameCommand(inputValue);

        return inputValue;
    }
}
