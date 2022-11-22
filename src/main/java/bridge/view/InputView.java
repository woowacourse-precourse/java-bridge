package bridge.view;

import bridge.domain.GameException;
import bridge.domain.GameStatus;
import bridge.domain.Move;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_ASK_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private InputView() {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String bridgeSize = Console.readLine();
        System.out.println();

        validatePositiveInt(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    private static void validatePositiveInt(String string) {
        if (!isAllDigit(string)) {
            throw new IllegalArgumentException(GameException.INVALID_POSITIVE_INTEGER.name());
        }
    }

    private static boolean isAllDigit(String string) {
        return string.chars()
                .allMatch(Character::isDigit);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static Move readMoving() {
        System.out.println(INPUT_MOVE_DIRECTION);

        return Move.from(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameStatus printAskRetry() {
        System.out.println(INPUT_ASK_RETRY);

        return GameStatus.receiveInputAfterGameOver(Console.readLine());
    }
}
