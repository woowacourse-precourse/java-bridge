package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
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
		List<String> bridge = initBridge();
		bridgeGame = new BridgeGame(bridge);
		gameProcess();
		OutputView.printResult(bridgeGame);
	}

	private void gameProcess() {
		while (true) {
			gameStart();
			if (bridgeGame.isGameLoss() && isRestartInput()) {
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
		} while (bridgeGame.isMatchDirection() && bridgeGame.isNotFinish());
	}

	private String inputDirection() {
		InputStringValidator moveCommandValidator = new InputStringValidator(InputView.readMoving());
		moveCommandValidator.isValidateAlphabet(UpDown.getStrValues());
		return moveCommandValidator.getInputValue();
	}

	private List<String> initBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		InputNumValidator bridgeSizeInputValidator = new InputNumValidator(InputView.readBridgeSize());
		return bridgeMaker.makeBridge(bridgeSizeInputValidator.getInputValue());
	}

	private boolean isRestartInput() {
		final List<String> RESTART_VALUE = List.of("R", "Q");
		InputStringValidator restartInputValidator = new InputStringValidator(InputView.readGameCommand());
		restartInputValidator.isValidateAlphabet(RESTART_VALUE);
		return restartInputValidator.getInputValue().equals("R");
	}

}
