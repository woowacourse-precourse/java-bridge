package bridge.view;

import bridge.Logger;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 제공된 InputView 클래스를 활용해 구현해야 한다. InputView의 패키지는 변경할 수 있다. InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다. 사용자 값
     * 입력을 위해 필요한 메서드를 추가할 수 있다.
     */

    private static final String BRIDGE_SIZE_INPUT_PROMPT = "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_PROMPT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INPUT_PROMPT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String INVALID_BRIDGE_SIZE =
            "다리 길이는 " + Bridge.MIN_SIZE + "부터 " + Bridge.MAX_SIZE + " 사이의 숫자여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(BRIDGE_SIZE_INPUT_PROMPT);
                int inputSize = readLineAndParseInt();
                validateBridgeSize(inputSize);
                return inputSize;
            } catch (IllegalArgumentException e) {
                Logger.log(e);
            }
        }
    }

    private int readLineAndParseInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
    }

    private void validateBridgeSize(int inputSize) {
        if (inputSize < Bridge.MIN_SIZE || inputSize > Bridge.MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Node readMoving() {
        while (true) {
            try {
                System.out.println(MOVE_INPUT_PROMPT);
                return Node.of(Console.readLine());
            } catch (IllegalArgumentException e) {
                Logger.log(e);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        while (true) {
            try {
                System.out.println(GAME_COMMAND_INPUT_PROMPT);
                return GameCommand.of(Console.readLine());
            } catch (IllegalArgumentException e) {
                Logger.log(e);
            }
        }
    }
}
