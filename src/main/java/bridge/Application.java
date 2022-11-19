package bridge;


import java.util.Arrays;

import static bridge.BridgeGame.Bridge;

public class Application {
    static InputView input = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    static int Location = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        System.out.println(Bridge);
        for (int i = 0; i < Bridge.size(); i++) {
            Bridge_Move();
        }
    }

    public static void init() {
        int size = input.readBridgeSize();
        Bridge = maker.makeBridge(size);
    }

    public static void Bridge_Move() {
        String Command = input.readGameCommand();
        outputView.Area_Division(Bridge, Command, Location);
        Location++;
        outputView.printMap();
    }
}
