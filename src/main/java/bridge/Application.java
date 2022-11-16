package bridge;

import bridge.message.PrintInput;

import java.util.List;

public class Application {

    public static boolean outcome;
    public static int attempt;

    public static void main(String[] args) {
        BridgeMaker randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView input = new InputView();
        OutputView output = new OutputView();
        PrintInput.START.print();
        BridgeGame bridgeGame = new BridgeGame(randomBridge.makeBridge(input.readBridgeSize()));
        attempt = 1;

        boolean playngBridge = true;

        while (playngBridge) {
            playngBridge = bridgeGame.move(input.readMoving());
            if (!bridgeGame.passHistory.contains("UX") && !bridgeGame.passHistory.contains("DX")) {
                output.printMap(bridgeGame.passHistory);
            }
        }
        output.printResult(attempt, outcome, bridgeGame.passHistory);
    }

    public boolean retry (List<String> passHistory) {
        OutputView output = new OutputView();
        InputView input = new InputView();

        output.printMap(passHistory);
        if (input.readGameCommand().equals("R")) {
            return true;
        }
        return false;
    }
}
