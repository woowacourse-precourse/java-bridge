package bridge.validation;

import bridge.constant.BridgeConstant;
import bridge.constant.GameCommand;

import static bridge.constant.BridgeConstant.*;
import static bridge.constant.GameCommand.*;

public class Validator {

    public String validateBridgeSize(String bridgeSize) {
        validateBridgeSizeFormat(bridgeSize);
        validateBridgeSizeRange(bridgeSize, BRIDGE_SIZE_START_INCLUSIVE.getValue(), BRIDGE_SIZE_END_INCLUSIVE.getValue());

        return bridgeSize;
    }

    public String validateBridgeSizeFormat(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return bridgeSize;
    }

    public void validateBridgeSizeRange(String bridgeSize, int startInclusive, int endInclusive) {
        int parsedBridgeSize = Integer.parseInt(bridgeSize);
        if (parsedBridgeSize < startInclusive || parsedBridgeSize > endInclusive) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public String validateStep(String step) {
        if (!step.equals(USER_STEP_FOR_UPPER_LAYER.getCommand()) &&
                !step.equals(USER_STEP_FOR_LOWER_LAYER.getCommand())) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸으로 위: U, 아래: D를 입력해주세요.");
        }

        return step;
    }

    public String validateRetryCommand(String command) {
        if (!command.equals(COMMAND_FOR_RETRY.getCommand()) &&
                !command.equals(COMMAND_FOR_QUIT.getCommand())) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작 여부로 재시도: R, 종료: Q를 입력해주세요.");
        }

        return command;
    }
}
