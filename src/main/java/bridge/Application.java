package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView OV = new OutputView();
        OV.startGuidance();
        InputView IV = new InputView();
        IV.readBridgeSize();
    }
}
