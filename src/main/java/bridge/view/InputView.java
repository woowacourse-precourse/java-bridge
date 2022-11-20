package bridge.view;

import static bridge.util.Constants.BRIDGE_SIZE_FORMAT;
import static bridge.util.Constants.EMPTY_INPUT;
import static bridge.util.Constants.ERROR_TITLE;
import static bridge.util.Constants.MAXIMUM_BRIDGE_SIZE;
import static bridge.util.Constants.MINIMUM_BRIDGE_SIZE;

import bridge.SafeBridge;
import bridge.util.CapitalLetter;
import bridge.util.CommandKeys;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 1. InputView의 패키지는 변경할 수 🌴있다.🌴
 * 2. InputView의 메소드 시그니처 (인자, 이름)와 반환 타입은 변경할 수 🌴있다.🌴
 * 3. 사용자 값 입력을 위해 필요한 메소드를 추가할 수 🌴있다.🌴
 * 4. InputView 클래스에서만 Console.readLine() 메소드를 이용해 사용자의 입력을 받을 수 🌴있다.🌴
 */
public class InputView {
    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_DIRECTION = String.format(
            "이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            CommandKeys.UP.getLetter(),
            CommandKeys.DOWN.getLetter()
    );
    private static final String ENTER_RETRY_OR_QUIT = String.format(
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            CommandKeys.RETRY.getLetter(),
            CommandKeys.QUIT.getLetter()
    );
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        final String input = messageBox(ENTER_BRIDGE_SIZE);
        System.out.println();
        return toBridgeSizeValue(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static CapitalLetter readMoving() {
        final String input = messageBox(ENTER_DIRECTION);
        return toMovingValue(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static CapitalLetter readGameCommand() {
        final String input = messageBox(ENTER_RETRY_OR_QUIT);
        return toGameCommandValue(input);
    }

    private static String messageBox(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static int toBridgeSizeValue(String input) {
        try {
            InputValidator.bridgeSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    private static CapitalLetter toMovingValue(String input) {
        final CapitalLetter letter;
        try {
            letter = new CapitalLetter(input);
            InputValidator.moving(letter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return letter;
    }

    private static CapitalLetter toGameCommandValue(String input) {
        final CapitalLetter letter;
        try {
            letter = new CapitalLetter(input);
            InputValidator.gameCommand(letter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return letter;
    }
}
