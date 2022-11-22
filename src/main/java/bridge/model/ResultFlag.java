package bridge.model;

public enum ResultFlag {
    SUCCESS("O", "성공"),
    FAIL("X", "실패"),
    NOTHING(" ", " ");

    private final String shape;
    private final String mean;

    ResultFlag(String shape, String mean) {
        this.shape = shape;
        this.mean = mean;
    }

    public String getShape() {
        return shape;
    }

    public String getMean() {
        return mean;
    }
}
