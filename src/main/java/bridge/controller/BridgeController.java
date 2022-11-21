package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.Message;
import bridge.enums.UpDown;
import bridge.view.InputNumValidator;
import bridge.view.InputStringValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
	private static final OutputView outputView = new OutputView();
	private static final InputView inputView = new InputView();
	private static BridgeGame bridgeGame;

	public void start() {
		outputView.printMessage(Message.GAME_START_MSG);
		List<String> bridge = initBridge();
		bridgeGame = new BridgeGame(bridge);
		do {
			bridgeGame.move(getDirection());
			outputView.printMap(bridgeGame);
		} while (bridgeGame.isMatchDirection());
	}

	private String getDirection() {
		InputStringValidator moveCommandValidator = new InputStringValidator(inputView.readMoving());
		moveCommandValidator.isValidateAlphabet(UpDown.getStrValues());
		return moveCommandValidator.getInputValue();
	}

	private List<String> initBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		InputNumValidator bridgeSizeInputValidator = new InputNumValidator(inputView.readBridgeSize());
		List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInputValidator.getInputValue());
		return bridge;
	}
}
