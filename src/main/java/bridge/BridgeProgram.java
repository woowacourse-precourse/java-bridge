package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeProgram {
	private final InputView inputView = new InputView();
	private final BridgeGame bridgeGame = new BridgeGame();
	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
	private final Bridge bridge = new Bridge();
	private final OutputView outputView = new OutputView();

	private final List<String> upBridge = new ArrayList<>();
	private final List<String> downBridge = new ArrayList<>();

	private int count = 1;
	private int stack = 0;

	public void useBridge() {
		bridge.matchBridge(bridgeMaker.makeBridge(checkBridgeSizeInputOrMove()));
	}

	private int checkBridgeSizeInputOrMove() {
		try {
			return inputView.readBridgeSize();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkBridgeSizeInputOrMove();
		}
	}

	private String checkMovingInput() {
		try {
			return inputView.readMoving();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkMovingInput();
		}
	}

	private String checkRetryInput() {
		try {
			return inputView.readGameCommand();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkRetryInput();
		}
	}

	public void loop() {
		for (upBridge.size(); checkRetry() && upBridge.size() < bridge.getBridgeSize(); ) {
			checkMoving(upBridge.size());
		}
	}

	public boolean checkRetry() {
		if (upBridge.contains(" X ") || downBridge.contains(" X ")) {
			String userRetry = checkRetryInput();
			if (!bridgeGame.retry(userRetry)) {
				return false;
			}
			setNumber();
		}
		return true;
	}

	public void setNumber() {
		clearList();
		stack = 0;
		count++;
	}

	public void winOrFail() {
		if (stack == bridge.getBridgeSize()) {
			outputView.win(count);
		}
		if (upBridge.contains(" X ") || downBridge.contains(" X ")) {
			outputView.Fail(count);
		}
	}

	public void totalResult() {
		outputView.printResult(upBridge,downBridge);
	}

	public void checkMoving(int i) {
		String userMoving = checkMovingInput();
		if (bridgeGame.move(userMoving)) {
			upMoving(i);
		}
		if (!bridgeGame.move(userMoving)) {
			downMoving(i);
		}
		outputView.printMap(upBridge,downBridge);
	}

	public void clearList() {
		upBridge.clear();
		downBridge.clear();
	}

	public void upPattern() {
		upBridge.add(" O ");
		downBridge.add("   ");
		stack++;
	}

	public void downPattern() {
		upBridge.add("   ");
		downBridge.add(" O ");
		stack++;
	}

	public void upMoving(int i) {
		if (bridge.getBridge().get(i).equals("U")) {
			upPattern();
		}
		if (bridge.getBridge().get(i).equals("D")) {
			upBridge.add(" X ");
			downBridge.add("   ");
		}
	}
}
