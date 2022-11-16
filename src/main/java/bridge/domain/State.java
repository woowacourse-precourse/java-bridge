package bridge.domain;

public enum State {
    SUCCESS("성공"),
    FAILURE("실패");

    private String korExplanation;

    State(String korExplanation) {
        this.korExplanation = korExplanation;
    }
}
