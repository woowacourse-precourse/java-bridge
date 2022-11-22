package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            InputView input = new InputView();
            OutputView output = new OutputView();
            Player player = new Player(input, output);
            BridgeGame bridgeGame = player.start();
            player.play(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
