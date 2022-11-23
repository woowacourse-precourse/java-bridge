package view;

import camp.nextstep.edu.missionutils.Console;

import static model.bridge.PositionType.D;
import static model.bridge.PositionType.U;
import static model.command.CommandType.Q;
import static model.command.CommandType.R;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_SIZE_ERROR = "다리 길이는 숫자여야 합니다.";
    private static final String MOVING_MESSAGE = NEW_LINE + String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", U, D);
    private static final String GAME_COMMAND_MESSAGE = NEW_LINE + String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", R, Q);

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        return toInteger(Console.readLine());
    }

    private int toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_COMMAND_MESSAGE);
        return Console.readLine();
    }
}
