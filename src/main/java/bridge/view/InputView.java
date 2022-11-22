package bridge.view;

import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.result.RetryCommand;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final String INIT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String SELECT_BLOCK_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public BridgeSize readBridgeSize() {
        System.out.println(INIT_BRIDGE_SIZE_MESSAGE);
        try {
            return new BridgeSize(readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readBridgeSize();
    }

    public BridgeBlock readMoving() {
        System.out.println(SELECT_BLOCK_MESSAGE);
        try {
            return BridgeBlock.convertTypeBlock(readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readMoving();
    }

    public RetryCommand readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        try {
            return RetryCommand.convertTypeCommand(readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readGameCommand();
    }
}
