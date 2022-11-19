package bridge.view.constant;

import bridge.constant.Directions;

public enum InputGuidePhrase {
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    PANEL("이동할 칸을 선택해주세요. (위: " + Directions.UP.getSymbol() + ", 아래: " + Directions.DOWN.getSymbol() + ")");

    private final String phrase;

    private InputGuidePhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
