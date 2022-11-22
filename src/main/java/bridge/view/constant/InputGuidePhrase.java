package bridge.view.constant;

import bridge.domain.constant.Directions;

public enum InputGuidePhrase {
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    PANEL("이동할 칸을 선택해주세요. (위: " + MoveOptions.UP.get() + ", 아래: " + MoveOptions.DOWN.get() + ")"),
    RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + RetryOptions.RETRY.get()
            + ", 종료: " + RetryOptions.QUIT.get() + ")");

    private final String phrase;

    private InputGuidePhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
