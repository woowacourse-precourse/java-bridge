package bridge.view;

import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.RetryCommand;
import bridge.system.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.*;

public class InputView {

    private final String INIT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String SELECT_BLOCK_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final Validation validation;

    public InputView() {
        validation = new Validation();
    }

    public int readBridgeSize() {
        System.out.println(INIT_BRIDGE_SIZE_MESSAGE);
        try {
            String bridgeSize = readLine();
            validation.validateBridgeSize(bridgeSize);
            return parseInt(bridgeSize);
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
