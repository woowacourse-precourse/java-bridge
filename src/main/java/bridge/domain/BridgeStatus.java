package bridge.domain;

public class BridgeStatus {
    String path;
    boolean pathAnswer;

    public BridgeStatus(String path, boolean pathAnswer) {
        this.path = path;
        this.pathAnswer = pathAnswer;
    }

    public String getPath() {
        return this.path;
    }

    public boolean getPathAnswer() {
        return this.pathAnswer;
    }
}
