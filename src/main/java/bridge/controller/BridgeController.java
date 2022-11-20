package bridge.controller;

import static bridge.message.MessageConstants.*;

import java.util.List;

import bridge.domain.ResultMessageStatus;
import bridge.domain.ResultStatus;
import bridge.filter.UserInputFilter;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final UserInputFilter filter = new UserInputFilter();
	private static final BridgeService bridgeService = new BridgeService();


	public void gameStart() {
		ResultStatus totalResult = ResultStatus.RETRY;
		outputView.printStartMessage();
		int bridgeSize = createBridgeGame();
		while (isExit(totalResult)) {
			totalResult = moveBridge(bridgeSize);
			totalResult = checkFailureResultStatus(totalResult);
		}
		printTotalResult(totalResult);
	}

	private ResultStatus moveBridge(int bridgeSize) {
		ResultStatus moveResult = ResultStatus.RETRY;
		while (!bridgeService.isFinish(moveResult, bridgeSize)) {
			String moveCommand = setMoveCommand();
			moveResult = bridgeService.moveService(moveCommand);
			printGameStageResult();
		}
		return moveResult;
	}


	private int createBridgeGame() {
		int bridgeSize = setBridgeSize();
		outputView.printEndl();
		bridgeService.createBridgeGame(bridgeSize);
		return bridgeSize;
	}

	private int setBridgeSize() {
		try {
			String userInput = inputView.readBridgeSize();
			return filter.bindingBridgeSize(userInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
			return setBridgeSize();
		}
	}

	private String setMoveCommand() {
		try {
			String moveCommand = inputView.readMoving();
			return filter.bindingMoveCommand(moveCommand);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
			return setMoveCommand();
		}
	}

	private String setRestartOrExit() {
		try {
			String userInput = inputView.readGameCommand();
			return filter.bindingRestartOrExitCommand(userInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
			return setRestartOrExit();
		}
	}

	private boolean isExit(ResultStatus totalResult) {
		return totalResult != ResultStatus.SUCCESS && totalResult != ResultStatus.FAILURE;
	}

	private boolean isRetry(String retryCommand) {
		return retryCommand.equals(RESTART_COMMAND_MESSAGE);
	}

	private void printGameStageResult() {
		List<ResultMessageStatus> resultMessageStatuses = bridgeService.getResultMessageStatuses();
		outputView.printMap(resultMessageStatuses);
	}

	private void printTotalResult(ResultStatus totalResult) {
		List<ResultMessageStatus> resultMessageStatuses = bridgeService.getResultMessageStatuses();
		int tryCount = bridgeService.getTryCount();
		outputView.printResult(resultMessageStatuses, totalResult, tryCount);
	}

	private ResultStatus checkFailureResultStatus(ResultStatus totalResult) {
		if (totalResult == ResultStatus.FAILURE) {
			String retryCommand = setRestartOrExit();
			if (isRetry(retryCommand)) {
				bridgeService.retryService();
				return ResultStatus.RETRY;
			}
		}
		return totalResult;
	}
}

