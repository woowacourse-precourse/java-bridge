package bridge.model;

import java.util.HashMap;
import java.util.Map;

public enum TypeOfBridge {
    UP_BRIDGE("U", "위", 1),
    DOWN_BRIDGE("D", "아래",  0),
    ;

    private static final Map<Integer, String> bridgeNumberText = new HashMap<>() {{
        for (TypeOfBridge rule : TypeOfBridge.values()) {
            put(rule.bridgeNumber, rule.text);
        }
    }};

    private final String text;

    private final String position;

    private final int bridgeNumber;

    TypeOfBridge(String text, String position, int bridgeNumber) {
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

    public String getText() {
        return text;
    }

    public String getPosition() {
        return position;
    }
}
