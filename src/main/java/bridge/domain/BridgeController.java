package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Util;
import bridge.enums.Constant;
import bridge.enums.Message;
import bridge.enums.UpDown;
import bridge.io.InputNumValidator;
import bridge.io.InputStringValidator;
import bridge.io.InputView;
import bridge.io.OutputView;

import java.util.List;

public class BridgeController {
	private static BridgeGame bridgeGame;

	public void start() {
		OutputView.printMessage(Message.GAME_START_MSG);
		bridgeGame = new BridgeGame(initBridge());
		gameProcess();
		OutputView.printResult(bridgeGame);
	}

	private List<String> initBridge() {
		InputNumValidator bridgeSizeInputValidator = new InputNumValidator(InputView.readBridgeSize());
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		return bridgeMaker.makeBridge(bridgeSizeInputValidator.getInputValue());
	}

	private void gameProcess() {
		while (true) {
			gameStart();
			if (BridgeGameCheck.isGameLoss(bridgeGame) && isRestartInput()) {
				bridgeGame.retry();
				continue;
			}
			break;
		}
	}

	private void gameStart() {
		do {
			bridgeGame.move(inputDirection());
			OutputView.printMap(bridgeGame);
		} while (BridgeGameCheck.isMatchingDirection(bridgeGame) && BridgeGameCheck.isNotFinish(bridgeGame));
	}

	private String inputDirection() {
		InputStringValidator moveCommandValidator = new InputStringValidator(InputView.readMoving());
		moveCommandValidator.isValidateAlphabet(UpDown.getDirectionValues());
		return moveCommandValidator.getInputValue();
	}

	private boolean isRestartInput() {
		InputStringValidator restartInputValidator = new InputStringValidator(InputView.readGameCommand());
		restartInputValidator.isValidateAlphabet(List.of(Constant.RESTART_YES.getValue(), Constant.RESTART_NO.getValue()));
		return Util.isSameString(Constant.RESTART_YES.getValue(), restartInputValidator.getInputValue());
	}
}
