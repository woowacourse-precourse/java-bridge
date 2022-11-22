package bridge.status;

public enum CountStatus {

    INITIALIZE_COUNT(0),
    INITIALIZE_TRY_COUNT(1);

    private Integer number;

    CountStatus(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
