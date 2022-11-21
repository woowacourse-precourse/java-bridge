package bridge;

public class Service {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private BridgeGame bridgeGame = new BridgeGame();
	private BridgeSize bridgeSize;
	private MessageQuestionPrint messageQuestionPrint = new MessageQuestionPrint();
	private int count = 1;
	private boolean successOrFail = true;

	public int checkUserCommend() {
		String userCommend = checkUserInputCommend();
		if (bridgeGame.retry(userCommend)) {
			outputView.resetBridgeMap();
			addCount();
			return Constant.INDEX_RESET_NUMBER;
		}
		setFail();
		return bridgeSize.getBridgeSize();
	}

	public void settingGame() {
		int userInputSize = checkUserInputBridgeSize();
		bridgeSize = new BridgeSize(userInputSize);
		bridgeGame.setBridge(userInputSize);
	}

	public void printResult() {
		outputView.printResult(getSuccessOrFail(), getCount());
	}

	public boolean getSuccessOrFail() {
		return successOrFail;
	}

	public void setFail() {
		successOrFail = false;
	}

	public void addCount() {
		count++;
	}

	public int getCount() {
		return count;
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