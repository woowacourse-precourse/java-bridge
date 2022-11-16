package bridge.view;

import bridge.utils.UserInputConvertor;
import bridge.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_MESSAGE_ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MESSAGE_ENTER_SPACE_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeLength() {
        System.out.println(INPUT_MESSAGE_ENTER_BRIDGE_LENGTH);
        return UserInputConvertor.mapToBridgeLength(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MESSAGE_ENTER_SPACE_TO_MOVE);
        String spaceToMove = Console.readLine();
        UserInputValidator.validateSpaceToMove(spaceToMove);
        return spaceToMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
