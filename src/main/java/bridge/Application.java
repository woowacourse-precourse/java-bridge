package bridge;

import bridge.controller.GamePlayer;
import bridge.view.OutputView;
public class Application {
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        outputView.printStart();
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.play();
    }
}
