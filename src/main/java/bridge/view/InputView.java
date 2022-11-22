package bridge.view;

import bridge.enums.BridgeMove;
import bridge.enums.GameCommand;

import static bridge.enums.BridgeBound.BOUND_MAX;
import static bridge.enums.BridgeBound.BOUND_MIN;
import static camp.nextstep.edu.missionutils.Console.readLine;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String MESSAGE_REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_REQUEST_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_REQUEST_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(MESSAGE_REQUEST_BRIDGE_SIZE);
        String inputBridgeSize = readLine();
        validateBridgeSize(inputBridgeSize);
        System.out.print("\n");
        return Integer.parseInt(inputBridgeSize);
    }

    private void validateBridgeSize(String bridgeSize) throws IllegalArgumentException {
        if (!bridgeSize.chars().allMatch(Character::isDigit) ||
                !((BOUND_MIN.getBound() <= Integer.parseInt(bridgeSize)) && (Integer.parseInt(bridgeSize) <= BOUND_MAX.getBound()))) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeMove readMoving() {
        System.out.println(MESSAGE_REQUEST_MOVING);
        String inputMoving = readLine();
        return BridgeMove.getEnum(inputMoving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(MESSAGE_REQUEST_GAME_COMMAND);
        return GameCommand.getEnum(readLine());
    }
}
