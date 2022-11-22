package bridge.generator;

public enum Answer {
    UP("U", 1),
    DOWN("D", 0);

    private final String letter;
    private final int number;

    Answer(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public static Answer getAnswerByNumber(int number) {
        if (number == UP.number) {
            return UP;
        }
        return DOWN;
    }
}
