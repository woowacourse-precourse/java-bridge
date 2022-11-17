package bridge.model;

import java.util.HashMap;
import java.util.Map;

public enum ContinueType {
    RETRY("R", "재시도"),
    QUIT("Q", "종료");

    private final String text;

    private final String description;

    private static final Map<String, ContinueType> textContinue = new HashMap<>() {{
        for (ContinueType type : ContinueType.values()) {
            put(type.text, type);
        }
    }};

    ContinueType(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public static ContinueType searchContinueTypeToText(String text) {
        ContinueType continueType = textContinue.get(text);

        if (continueType == null) {
            throw new IllegalArgumentException("허용되지 않는 글자입니다. 재시도 여부를 선택할 수 없습니다.");
        }

        return continueType;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
}
