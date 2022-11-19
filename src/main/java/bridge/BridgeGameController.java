package bridge;

public class BridgeGameController {
	
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	
	public void startGame() {
		outputView.gameStartMessage();
		
	}
}
