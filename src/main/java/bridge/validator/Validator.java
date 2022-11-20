package bridge.validator;

import bridge.domain.BridgeSpec;

public class Validator {

    public static void validateBridgeSize(int size) {
        if (size < BridgeSpec.MIN.size() || size > BridgeSpec.MAX.size()) {
            throw new IllegalArgumentException("[ERROR] 3과 20 사이의 수를 입력하세요.");
        }
    }

}
