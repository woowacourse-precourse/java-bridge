package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView OV = new OutputView();
        OV.startGuidance();
        InputView IV = new InputView();
        BridgeNumberGenerator BNG = new BridgeRandomNumberGenerator();
        BridgeMaker BM = new BridgeMaker(BNG);
        System.out.println(BM.makeBridge(IV.readBridgeSize()));
    }
}
