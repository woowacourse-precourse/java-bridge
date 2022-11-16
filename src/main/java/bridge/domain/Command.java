package bridge.domain;

public enum Command {
    UP('U', "위"),
    DOWN('D', "아래"),
    RETRY('R', "재시도"),
    QUIT('Q', "종료");

    private char abbreviation;
    private String korExplanation;

    Command(char abbreviation, String korExplanation) {
        this.abbreviation = abbreviation;
        this.korExplanation = korExplanation;
    }
}
