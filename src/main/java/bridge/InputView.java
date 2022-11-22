package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String ENTER_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String RESTART_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static final String BRIDGE_SIZE_EXCEPTION = "[ERROR] 다리 길이는 3이상 20사이의 숫자를 입력할 수 있습니다.";
    static final String NUMBER_EXCEPTION = "[ERROR] 숫자만 입력가능합니다.";
    static final String NOTHING_EXCEPTION = "[ERROR] 입력 값이 없어 종료합니다.";
    static final String BRIDGE_MOVING_EXCEPTION = "[ERROR] U와 D만 입력 가능 합니다.";
    static final String BRIDGE_GAME_RESTART_EXCEPTION = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            System.out.println(ENTER_BRIDGE_SIZE);
            int bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < 3 | bridgeSize > 20) {
                System.out.println(BRIDGE_SIZE_EXCEPTION);
                return readBridgeSize();
            }
            return bridgeSize;
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_EXCEPTION);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {

        System.out.println(ENTER_UP_OR_DOWN);
        String selectMove = Console.readLine();
        System.out.println(selectMove);
        if (!Objects.equals(selectMove, "U") && !Objects.equals(selectMove, "D")) {
            System.out.println(BRIDGE_MOVING_EXCEPTION);
            return readMoving();
        }
        return selectMove;


    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(RESTART_GAME);
        try {
            String selectRestart =  Console.readLine();
            if (!Objects.equals(selectRestart, "R") && !Objects.equals(selectRestart, "Q")){
                System.out.println(BRIDGE_GAME_RESTART_EXCEPTION);
                return readGameCommand();
            }
            return selectRestart;
        } catch (NoSuchElementException e) {
            System.out.println(NOTHING_EXCEPTION);
            return "Q";
        } catch (IllegalArgumentException e) {
            System.out.println(BRIDGE_GAME_RESTART_EXCEPTION);
            return readGameCommand();
        }
    }
}
