package bridge.status;

public enum BoundaryStatus {

    MIN_LENGTH(3),
    MAX_LENGTH(20);

    private Integer length;

    BoundaryStatus(Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }
}
