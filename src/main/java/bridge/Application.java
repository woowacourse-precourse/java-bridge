package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(new InputView(), new OutputView());
        List<String> answers = bridgeGame.gameSet();
        do {
            bridgeGame.play(answers);
        } while (bridgeGame.retry());
    }
}
