package bridge;

import model.BridgeGame;
import view.OutputView;

public class Application {

    private static final OutputView outputView = OutputView.getInstance();

    public static void main(String[] args) {
        try {
            outputView.printStart();
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.run();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
