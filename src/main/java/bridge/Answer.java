package bridge;

public enum Answer {
    UP_CORRECT(UpDown.UP,true),
    UP_INCORRECT(UpDown.UP,false),
    DOWN_CORRECT(UpDown.DOWN,true),
    DOWN_INCORRECT(UpDown.DOWN,false)
    ;

    private final UpDown upDown;
    private final boolean isCorrect;

    Answer(UpDown upDown, boolean isCorrect) {
        this.upDown = upDown;
        this.isCorrect = isCorrect;
    }

    public UpDown getUpDown() {
        return upDown;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
