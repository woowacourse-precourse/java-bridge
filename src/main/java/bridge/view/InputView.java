package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.constant.BridgeGameInfo;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() throws IllegalArgumentException {
        System.out.println(BridgeGameInfo.INPUT_BRIDGE_SIZE.message);
        // 다리 길이 입력받기
        String userInputBridgeSize = Console.readLine();

        // 숫자 형태가 아니면 예외
        for (int i = 0; i < userInputBridgeSize.length(); i++) {
            char input = userInputBridgeSize.charAt(i);
            if ((int) input < 48 || (int) input > 57) {
                throw new IllegalArgumentException();
            }
        }

        int size = Integer.parseInt(userInputBridgeSize);

        // 범위 벗어나면 예외
        if (size < 3 ||  19 < size) {
            throw new IllegalArgumentException();
        }

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(BridgeGameInfo.SELECT_UP_DOWN.message);
        // 이동할 칸 입력받기
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(BridgeGameInfo.RESTART.message);
        // 다시 시도지 종료할지 입력받는다.
        return Console.readLine();
    }
}
