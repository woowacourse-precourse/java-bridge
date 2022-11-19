package bridge.model;

import java.util.Arrays;

public enum BridgeType {
    UP_BRIDGE("U", "위", 1),
    DOWN_BRIDGE("D", "아래", 0),
    ;

    private final String text;

    private final String position;

    private final int bridgeNumber;

    BridgeType(String text, String position, int bridgeNumber) {
        this.text = text;
        this.position = position;
        this.bridgeNumber = bridgeNumber;
    }

    public static String convertRandomNumberToText(int randomNumber) {
        return Arrays.stream(BridgeType.values())
                .filter(bt -> bt.bridgeNumber == randomNumber)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("허용되지 않는 랜덤 숫자입니다. 일치하는 텍스트를 찾을 수 없습니다."))
                .text;
    }

    public static BridgeType searchBridgeToText(String text) {
        return Arrays.stream(BridgeType.values())
                .filter(bt -> bt.text.equals(text))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("허용되지 않는 글자입니다. 일치하는 다리를 찾을 수 없습니다."));
    }

    public String getText() {
        return text;
    }

    public String getPosition() {
        return position;
    }
}
