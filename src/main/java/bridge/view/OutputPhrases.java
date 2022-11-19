package bridge.view;

public enum OutputPhrases {
    finalGameResult("최종 게임 결과"),
    gameStatus("게임 성공 여부: "),
    numberOfAttempts("총 시도한 횟수: "),
    startGame("다리 건너기 게임을 시작합니다.");

    private String phrase;

    OutputPhrases(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}