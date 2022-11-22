package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String UPWARD_DIRECTION = "U";
    public static final String DOWNWARD_DIRECTION = "D";
    public static final String LINE_SPACE = "";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private static final String INPUT_BRIDGE_LENGTH_INTRO = "다리의 길이를 입력해주세요.";
    private static final String INPUT_BRIDGE_MOVE_INTRO = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RETRY_INTRO = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 값은 숫자로만 입력해주세요.";
    private static final String NUMBER_RANGE_ERROR = "[ERROR] 값은 3 이상 20 이하 숫자만 가능합니다.";
    private static final String MOVE_VALUE_ERROR = "[ERROR] 값은 D 혹은 U로만 입력이 가능합니다.";
    private static final String MOVE_RETRY_VALUE_ERROR = "[ERROR] 값은 R 혹은 Q로만 입력이 가능합니다.";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";


    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_INTRO);
        String input = Console.readLine();

        int convertedNumber = convertToNumber(input);
        return validRange(convertedNumber);
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_NUMBER_ERROR);
            return readBridgeSize();
        }
    }

    public static int validRange(int convertedNumber) {
        try {
            if (convertedNumber < MIN_SIZE || convertedNumber > MAX_SIZE) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }
            return convertedNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(NUMBER_RANGE_ERROR);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(LINE_SPACE);
        System.out.println(INPUT_BRIDGE_MOVE_INTRO);
        String inputMoving = Console.readLine().trim();
        return validValue(inputMoving);
    }

    public static String validValue(String inputMoving) {
        try {
            if (!inputMoving.equals(DOWNWARD_DIRECTION) && !inputMoving.equals(UPWARD_DIRECTION)) {
                throw new IllegalArgumentException(MOVE_VALUE_ERROR);
            }
            return inputMoving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(LINE_SPACE);
        System.out.println(GAME_RETRY_INTRO);
        String continueGame = Console.readLine().trim();
        return validContinue(continueGame);
    }

    public static String validContinue(String continueGame) {
        try {
            if (!continueGame.equals(RETRY) && !continueGame.equals(QUIT)) {
                throw new IllegalArgumentException(MOVE_RETRY_VALUE_ERROR);
            }
            return continueGame;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

}
