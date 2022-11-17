package bridge;

public class BridgeProcess {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void startGame(){
        outputView.printStartingPhrase();
    }

}
