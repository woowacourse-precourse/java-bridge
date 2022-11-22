package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.Direction;
import bridge.domain.Progress;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String size = readLine();
        validateNumeric(size);
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String guide = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
        System.out.printf(
                (guide) + "%n", Direction.UP, Direction.DOWN);
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String guide = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)";
        System.out.printf(
                (guide) + "%n", Progress.RETRY, Progress.QUIT);
        return readLine();
    }

    private static void validateNumeric(String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
