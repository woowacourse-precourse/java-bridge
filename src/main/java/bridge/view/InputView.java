package bridge.view;

import static bridge.domain.constants.GameCommands.QUIT_GAME_COMMAND;
import static bridge.domain.constants.GameCommands.RESTART_GAME_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * TODO 메서드 시그니처(인자, 이름)와 반환 타입 변경 가능
 * TODO 메서드 추가 가능
 */
public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_VALID_BRIDGE_LENGTH = "다리의 길이는 3 이상 20 이하여야 합니다.";

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

    // TODO : 아래의 validation 로직 어쩔껴?!
    private void validateThisIsNumber(String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private void validateBridgeSize(int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(NOT_VALID_BRIDGE_LENGTH);
        }
    }

    private void validateCorrectValueForMoving(String inputValue) {
        if (!inputValue.equals(MOVE_UP_COMMAND) && !inputValue.equals(MOVE_DOWN_COMMAND)) {
            throw new IllegalArgumentException("U 또는 D만 입력해 주세요. (U:위, D:아래)");
        }
    }

    private void validateCorrectValueForGameCommand(String inputValue) {
        if (!inputValue.equals(RESTART_GAME_COMMAND) && !inputValue.equals(QUIT_GAME_COMMAND)) {
            throw new IllegalArgumentException("R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)");
        }
    }
}
