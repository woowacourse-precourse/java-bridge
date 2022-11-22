package bridge.view;

import bridge.model.Command;
import bridge.model.Move;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_WHETHER_TO_TRY = "게임을 다시 시도할지 여부를 입력해주세요.";
    private static final String SELECT_A_SPACE_TO_MOVE = "이동할 칸을 선택해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public Integer readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
        String input = readInput();
        System.out.println();
        return validate(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.printf("%s (위: %s, 아래: %s)%n", SELECT_A_SPACE_TO_MOVE, Move.U, Move.D);
        return readInput();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.printf("%s (재시도: %s, 종료: %s)%n", ENTER_WHETHER_TO_TRY, Command.R, Command.Q);
        return readInput();
    }

    private String readInput() {
        return Console.readLine();
    }

    private Integer validate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자연수를 입력하셔야 합니다.");
        }
    }
}
