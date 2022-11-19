package bridge;


import java.util.Arrays;

import static bridge.BridgeGame.Bridge_U;

public class Application {
    static InputView input = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int size = input.readBridgeSize();
        Bridge_U = maker.makeBridge(size);
        Bridge_Move();
    }

    public static void Bridge_Move() {
        String Command = input.readGameCommand();
        int Correct[] = bridgeGame.move(Command);
        System.out.println(Arrays.toString(Correct));

    }
}
