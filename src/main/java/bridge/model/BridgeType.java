package bridge.model;

import java.util.HashMap;
import java.util.Map;

public enum BridgeType {
    UP_BRIDGE("U", "위", 1),
    DOWN_BRIDGE("D", "아래",  0),
    ;

    private static final Map<Integer, String> bridgeNumberText = new HashMap<>() {{
        for (BridgeType type : BridgeType.values()) {
            put(type.bridgeNumber, type.text);
        }
    }};

    private static final Map<String, BridgeType> textBridge = new HashMap<>() {{
        for (BridgeType type : BridgeType.values()) {
            put(type.text, type);
        }
    }};

    private final String text;

    private final String position;

    private final int bridgeNumber;

    BridgeType(String text, String position, int bridgeNumber) {
        this.text = text;
        this.position = position;
        this.bridgeNumber = bridgeNumber;
    }

    public static String convertRandomNumberToText(int randomNumber) {
        String bridgeText = bridgeNumberText.get(randomNumber);

        if (bridgeText == null) {
            throw new IllegalArgumentException("허용되지 않는 랜덤 숫자입니다. 일치하는 텍스트를 찾을 수 없습니다.");
        }

        return bridgeText;
    }

    public static BridgeType searchBridgeToText(String text) {
        BridgeType bridge = textBridge.get(text);

        if (bridge == null) {
            throw new IllegalArgumentException("허용되지 않는 글자입니다. 일치하는 다리를 찾을 수 없습니다.");
        }

        return bridge;
    }

    public String getText() {
        return text;
    }

    public String getPosition() {
        return position;
    }
}
