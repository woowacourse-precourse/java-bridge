package bridge;


import static bridge.BridgeGame.Bridge_U;

public class Application {
    static InputView input = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int size = input.readBridgeSize();
        Bridge_Make(size);
    }

    public static void Bridge_Make(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);
        Bridge_U = maker.makeBridge(size);
    }
}
