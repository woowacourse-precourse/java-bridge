package bridge.view;

import bridge.util.CommandKeys;
import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_MOVING = String.format(
            "이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            CommandKeys.UP.getLetter(),
            CommandKeys.DOWN.getLetter()
    );
    private static final String ENTER_RETRY_OR_QUIT = String.format(
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            CommandKeys.RETRY.getLetter(),
            CommandKeys.QUIT.getLetter()
    );

    public static int readBridgeSize() {
        final String input = submitBoxWithLineFeed(ENTER_BRIDGE_SIZE);
        try {
            InputValidator.bridgeSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return extractNumber(input);
    }

    public static String readMoving() {
        final String input = submitBox(ENTER_MOVING);
        try {
            InputValidator.moving(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return capitalize(input);
    }

    public static String readGameCommand() {
        final String input = submitBox(ENTER_RETRY_OR_QUIT);
        try {
            InputValidator.gameCommand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return capitalize(input);
    }

    private static String submitBox(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static String submitBoxWithLineFeed(String message) {
        System.out.println(message);
        final String input = Console.readLine();
        System.out.println();
        return input;
    }

    private static int extractNumber(String input) {
        return Integer.parseInt(input);
    }

    private static String capitalize(String input) {
        return input.toUpperCase();
    }
}
