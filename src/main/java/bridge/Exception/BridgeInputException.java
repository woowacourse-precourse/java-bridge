package bridge.Exception;

import java.util.regex.Pattern;

public class BridgeInputException {

    public void validBridgeRetry(String retry) {
        validInputFormRetry(retry);
        validInputSizeRetry(retry);
    }

    public void validBridgeLength(String size) {
        validInputFormLength(size);
        validInputRangeLength(size);
    }

    public void validMoveDirection(String direction) {
        validInputFormMove(direction);
        validInputSizeMove(direction);
    }

    private void validInputFormRetry(String retry) {
        String regexInput = "^[QR]*$";
        if (!Pattern.matches(regexInput, retry)) {
            throw new IllegalArgumentException("[ERROR] 재시작/종료 여부는 R 또는 Q만 입력하세요");
        }
    }

    private void validInputSizeRetry(String retry) {
        if (retry.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 재시작/종료 여부는 한 문자로 입력하세요.");
        }
    }

    private void validInputFormLength(String lenBridge) {
        try {
            Integer.parseInt(lenBridge);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력하세요.");
        }
    }

    private void validInputRangeLength(String lenBridge) {
        int len = Integer.parseInt(lenBridge);
        if (len < 3 || len > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3 이상 20 이하의 숫자입니다.");
        }
    }

    private void validInputFormMove(String direction) {
        String regexInput = "^[UD]*$";
        if (!Pattern.matches(regexInput, direction)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D만 입력하세요.");
        }
    }

    private void validInputSizeMove(String direction) {
        if (direction.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 한 문자만 입력하세요.");
        }
    }
}
