package bridge;

public class GamePlay {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public GamePlay() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
