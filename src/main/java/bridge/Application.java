package bridge;

import static bridge.OutputView.*;

public class Application {

	public static void main(String[] args) {
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();
		try {
			final BridgeGame game = start(inputView, outputView);
			proceed(inputView, outputView, game);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e.getMessage());
		}
	}

	private static void proceed(InputView inputView, OutputView outputView, BridgeGame game) {
		boolean result;
		do {
			result = move(inputView, outputView, game);
			if (!result) {
				outputView.printRestartOrExit();
			}
		} while (!isFailure(inputView, game, result) && !isSuccess(game, result));
		outputView.printResult(game);
	}

	private static boolean isSuccess(BridgeGame game, boolean result) {
		return result && game.getCurrentIndex() == game.getBridgeLength();
	}

	private static boolean isFailure(InputView inputView, BridgeGame game, boolean result) {
		return !result && !game.retry(inputView.readGameCommand());
	}

	private static boolean move(InputView inputView, OutputView outputView, BridgeGame game) {
		outputView.printAnnouncement(INPUT_MOVEMENT_ANNOUNCEMENT);
		final boolean result = game.move(inputView.readMoving());
		outputView.printMap(game);
		return result;
	}

	private static BridgeGame start(InputView inputView, OutputView outputView) {
		final int bridgeLength = readBridgeLength(inputView, outputView);
		return new BridgeGame(bridgeLength);
	}

	private static int readBridgeLength(InputView inputView, OutputView outputView) {
		outputView.printAnnouncement(START_ANNOUNCEMENT);
		outputView.printAnnouncement(INPUT_BRIDGE_LENGTH_ANNOUNCEMENT);
		return inputView.readBridgeSize();
	}

}
