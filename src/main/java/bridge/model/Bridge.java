package bridge.model;

public class Bridge {
    private final String position;
    private final String result;

    public Bridge(String position, String result) {
        this.position = position;
        this.result = result;
    }

    public String getPosition() {
        return position;
    }

    public String getResult() {
        return result;
    }
}
