package bridge.enums;

public enum Answer {
    Up("U", 1, "위"),
    Down("D", 0, "아래"),
    Quit("Q", -1, "종료"),
    Retry("R", 2, "재시도");

    final private String answer;
    final private int mark;
    final private String description;

    Answer(String answer, int mark, String description) {
        this.answer = answer;
        this.mark = mark;
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public int getMark() {
        return mark;
    }

    public String getDescription() {
        return description;
    }

    public static String markConvertAnswer(int mark) {
        if (Answer.Up.getMark() == mark) {
            return Answer.Up.getAnswer();
        } else {
            return Answer.Down.getAnswer();
        }
    }

}
