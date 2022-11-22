package bridge.domain;

public class Attempt {
    private Integer count;

    public Attempt() {
        this.count = 1;
    }

    public void addCount() {
        count++;
    }

    public Integer getCount() {
        return count;
    }
}
