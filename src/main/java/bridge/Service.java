package bridge;

public class Service {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private BridgeGame bridgeGame = new BridgeGame();
	private MessageQuestionPrint messageQuestionPrint = new MessageQuestionPrint();
	private BridgeSize bridgeSize;
	private boolean successOrFail = true;

	public boolean getSuccessOrFail() {
		return successOrFail;
	}

	public void setFail() {
		successOrFail = false;
	}

	private String checkUserInputMove() {
		try {
			messageQuestionPrint.userMoveQuestion();
			return inputView.readMoving();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkUserInputMove();
		}
	}

	private String checkUserInputCommend() {
		try {
			messageQuestionPrint.userCommandQuestion();
			return inputView.readGameCommand();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkUserInputCommend();
		}
	}

	private int checkUserInputBridgeSize() {
		try {
			messageQuestionPrint.inputBridgeSizeQuestion();
			return inputView.readBridgeSize();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkUserInputBridgeSize();
		}
	}
}