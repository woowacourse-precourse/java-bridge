package bridge.view.inputCallback;

import bridge.model.bridge.Bridge;
import camp.nextstep.edu.missionutils.Console;

public class ReadBridgeSizeCallback implements ReadLineCallback<Integer> {
    private static final String BRIDGE_SIZE_INPUT_PROMPT = "다리의 길이를 입력해주세요.";
    private static final String INVALID_BRIDGE_SIZE = String.format("다리 길이는 %d 부터 %d 사이의 숫자여야합니다.", Bridge.MIN_SIZE,
            Bridge.MAX_SIZE);

    @Override
    public Integer repeatToRead() {
        System.out.println(BRIDGE_SIZE_INPUT_PROMPT);
        int inputSize = readLineAndParseInt();
        validateBridgeSize(inputSize);
        return inputSize;
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

}
