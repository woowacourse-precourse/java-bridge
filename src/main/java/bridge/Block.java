package bridge;


public enum Block {
    NULL_BLOCK(0," "),
    TRUE_BLOCK(1,"O"),
    FALSE_BLOCK(-1, "X");
    private int correct_size;
    private String result;

    Block(int correct_size, String result) {
        this.correct_size = correct_size;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public int getCorrect() {
        return correct_size;
    }

    public static String getMessage(final int correct_size) {
        for (Block b : Block.values()) {
            if (b.correct_size == correct_size) {
                return b.getResult();
            }
        }
        return "";
    }
}
