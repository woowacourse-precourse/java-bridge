package bridge.view;

import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.Command;
import bridge.domain.dto.Place;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_PLACE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public BridgeSize readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        System.out.println();

        return new BridgeSize(bridgeSize);
    }

    public Place readMoving() {
        System.out.println(MOVE_PLACE_MESSAGE);
        String move = Console.readLine();

        return new Place(move);
    }

    public Command readGameCommand() {
        System.out.println(COMMAND_MESSAGE);
        String command = Console.readLine();

        return new Command(command);
    }
}
