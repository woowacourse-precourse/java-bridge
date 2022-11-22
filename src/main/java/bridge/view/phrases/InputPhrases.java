package bridge.view.phrases;

public enum InputPhrases {
    readBridgeSize("다리의 길이를 입력해주세요."),
    readMoving("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    readGameCommand("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String phrase;

    InputPhrases(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
