package bridge;

public class BridheGameController {
    public BridheGameController() {
        gameStart();
    }

    private void gameStart() {
        OutputView outputView = new OutputView();
        outputView.printgameStart();
    }
}
