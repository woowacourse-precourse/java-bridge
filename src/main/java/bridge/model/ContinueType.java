package bridge.model;

import java.util.Arrays;

public enum ContinueType {
    RETRY("R", "재시도"),
    QUIT("Q", "종료");

    private final String text;

    private final String description;

    ContinueType(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public static ContinueType searchContinueTypeToText(String text) {
        return Arrays.stream(ContinueType.values())
                .filter(ct -> ct.text.equals(text))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("허용되지 않는 글자입니다. 재시도 여부를 선택할 수 없습니다."));
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
}
