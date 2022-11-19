package bridge.domain;

public class Location {
    private int location;

    public void init() {
        location = 0;
    }

    public void moveNext() {
        location++;
    }

    public int getLocation() {
        return location;
    }
}
