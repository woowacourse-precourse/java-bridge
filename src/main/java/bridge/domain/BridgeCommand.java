package bridge.domain;

public enum BridgeCommand {

    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    String element;

    public String getElement() {
        return element;
    }


    BridgeCommand(String element) {
        this.element = element;
    }
}
