package bridge.enums;

public enum UserAnswer {
    Up("U", 1, "위"),
    Down("D", 0, "아래"),
    Quit("Q", -1, "종료"),
    Retry("R", 1, "재시도");

    final private String answer;
    final private int mark;
    final private String description;

    UserAnswer(String answer, int mark, String description) {
        this.answer = answer;
        this.mark = mark;
        this.description = description;
    }

    public int getMark() {
        return mark;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswer() {
        return answer;
    }

}
