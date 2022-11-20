package bridge.service;

import static bridge.message.MessageConstants.*;

import java.util.List;

import bridge.domain.BridgeGame;
import bridge.domain.ResultMessageStatus;
import bridge.domain.ResultStatus;
import bridge.filter.UserInputFilter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeService {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final UserInputFilter filter = new UserInputFilter();
	private int bridgeSize;
	private String moveCommand;
	private String retryCommand;
	private BridgeGame bridgeGame;
	private ResultStatus totalResult;

	public void gameStart() {
		totalResult = ResultStatus.RETRY;
		outputView.printStartMessage();
		createBridgeGame();
		while (isExit()) {
			totalResult = moveBridge();
			checkFailureResultStatus();
		}
		printTotalResult();
	}

	private void createBridgeGame() {
		setBridgeSize();
		outputView.printEndl();
		bridgeGame = new BridgeGame(bridgeSize);
	}

	private void setBridgeSize() {
		try {
			String userInput = inputView.readBridgeSize();
			bridgeSize = filter.bindingBridgeSize(userInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
			setBridgeSize();
		}
	}

	private ResultStatus moveBridge() {
		ResultStatus moveResult = ResultStatus.RETRY;
		while (!bridgeGame.isFinish(moveResult, bridgeSize)) {
			setMoveCommand();
			moveResult = bridgeGame.move(moveCommand);
			printGameStageResult();
		}
		return moveResult;
	}

	private void setMoveCommand() {
		try {
			moveCommand = inputView.readMoving();
			filter.bindingMoveCommand(moveCommand);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
			setMoveCommand();
		}
	}

	private void checkFailureResultStatus() {
		if (totalResult == ResultStatus.FAILURE) {
			askRestartOrExit();
			if (isRetry()) {
				totalResult = ResultStatus.RETRY;
				bridgeGame.retry();
			}
		}
	}

	private void askRestartOrExit() {
		try {
			String userInput = inputView.readGameCommand();
			retryCommand = filter.bindingRestartOrExitCommand(userInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
			askRestartOrExit();
		}
	}

	private boolean isRetry() {
		return retryCommand.equals(RESTART_COMMAND_MESSAGE);
	}

	private boolean isExit() {
		return totalResult != ResultStatus.SUCCESS && totalResult != ResultStatus.FAILURE;
	}

	private void printGameStageResult() {
		List<ResultMessageStatus> resultMessageStatuses = bridgeGame.getResultMessageStatuses();
		outputView.printMap(resultMessageStatuses);
	}

	private void printTotalResult() {
		List<ResultMessageStatus> resultMessageStatuses = bridgeGame.getResultMessageStatuses();
		int tryCount = bridgeGame.getTryCount();
		outputView.printResult(resultMessageStatuses, totalResult, tryCount);
	}
}
