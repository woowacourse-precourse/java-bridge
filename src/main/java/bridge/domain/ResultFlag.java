package bridge.domain;

public enum ResultFlag {
    SUCCESS("O", "성공"),
    FAIL("X", "실패"),
    NOTHING(" ","");

    private final String flag;
    private final String mean;

    ResultFlag(String flag, String mean) {
        this.flag = flag;
        this.mean = mean;
    }

    public String getMean() {
        return mean;
    }

    @Override
    public String toString() {
        return flag;
    }
}
