package bridge;

import java.util.List;

public class GameController {

    private final RoundController roundController;
    private final InputView inputView;
    private final OutputView outputView;
    private final StateView stateView;
    private List<String> bridgeShape;

    public GameController(RoundController roundController) {
        this.roundController = roundController;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stateView = new StateView();
    }

    public void initialize() {
        stateView.printInitialization();
        roundController.makeBridgeWithSize();
    }

    public void bridgeGame() {
        roundController.bridgeRound();
    }
}
