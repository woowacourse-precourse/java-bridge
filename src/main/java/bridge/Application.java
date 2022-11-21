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
    static String Command;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        System.out.println(Bridge);
        while (Location < Bridge.size() && bridgeGame.Ending()) {
            Bridge_Move();
            Bridge_Check();
            Location++;
        }
    }

    public static void init() {
        int size = input.readBridgeSize();
        Bridge = maker.makeBridge(size);
    }

    public static void Bridge_Move() {
        Command = input.readMoving();
        outputView.Area_Division(Bridge, Command, Location);
        outputView.printMap();
    }

    private static void Bridge_Check() {
        String Retry_Command = null;
        if (bridgeGame.move(Command, Location)) {
            Retry_Command = input.readGameCommand();
            RetryPrint(Retry_Command);
            Location = bridgeGame.retry(Retry_Command, Location);

        }
    }

    private static void RetryPrint(String Retry_Command) {
        if (Retry_Command.equals("R")) {
            outputView.Delete_Bridge();
        }
        if (Retry_Command.equals("Q")) {
            outputView.printResult();
        }
    }
}
