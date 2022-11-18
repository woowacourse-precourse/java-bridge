package bridge.view;

import bridge.domain.Bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n" + "다리의 길이를 입력해주세요.";
    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: " + Bridge.up + ", 아래: " + Bridge.down + ")";
    private static final String COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);

        String bridgeSize = Console.readLine();
        return convertStringToInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_INPUT_MESSAGE);

        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(COMMAND_INPUT_MESSAGE);

        return Console.readLine();
    }

    private int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }
}
