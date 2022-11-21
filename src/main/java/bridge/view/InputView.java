package bridge.view;

import bridge.dto.BridgeSize;
import bridge.dto.Command;
import bridge.dto.Place;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 여기서만 사용자 입력 받음
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 가능
 * 입력을 위해 필요한 메서드 추가 가능
 */
public class InputView {

    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_PLACE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();

        return new BridgeSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Place readMoving() {
        System.out.println(MOVE_PLACE_MESSAGE);
        String move = Console.readLine();

        return new Place(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        System.out.println(COMMAND_MESSAGE);
        String command = Console.readLine();

        return new Command(command);
    }
}
