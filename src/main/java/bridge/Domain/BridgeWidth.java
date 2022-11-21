package bridge.Domain;

public enum BridgeWidth {
    WIDTH1(1, "U"),
    WIDTH2(0, "D");

    private int number;
    private String widthPosition;

    private BridgeWidth(int number, String widthPosition){
        this.number = number;
        this.widthPosition = widthPosition;
    }
}
