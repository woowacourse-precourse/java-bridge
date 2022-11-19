package bridge.view;

public enum Phrases {
    readBridgeSize("다리의 길이를 입력해주세요."),
    readMoving("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private String phrase;

    Phrases(String phrase) {
        this.phrase = phrase;
    }
}
