package bridge.status;

public enum NumberStatus {

    ZERO(0);

    private Integer number;

    NumberStatus(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}

