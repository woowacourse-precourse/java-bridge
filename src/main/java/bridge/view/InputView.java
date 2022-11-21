package bridge.view;

import bridge.exception.BridgeException;
import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.BridgeException.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final BridgeException bridgeException = new BridgeException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return bridgeSizeException(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return movingException(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String input) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return bridgeException.gameCommandException(input);
    }
}
