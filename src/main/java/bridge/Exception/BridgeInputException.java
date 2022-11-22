package bridge.Exception;

import java.util.regex.Pattern;

public class BridgeInputException {

    private void validInputFormRetry(String retry) {
        String regexInput = "^[QR]*$";
        if (!Pattern.matches(regexInput, retry)) {
            throw new IllegalArgumentException("[ERROR] 재시작/종료 여부는 R 또는 Q만 입력하세요");
        }
    }

}
