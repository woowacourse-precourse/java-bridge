package bridge.domain;

public enum GameResult {
    SUCCESS("성공"),
    REGAME("리게임"),
    FAILURE("실패");

    private String korExplanation;

    GameResult(String korExplanation) {
        this.korExplanation = korExplanation;
    }

    public String getKorState() {
        return this.korExplanation;
    }
}
