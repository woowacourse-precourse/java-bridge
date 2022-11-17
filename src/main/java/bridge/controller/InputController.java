package bridge.controller;

import bridge.service.InputValidService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {

	private final InputView inputView;
	private final InputValidService inputValidService;
	private final OutputView outputView;

	public InputController(InputView inputView, InputValidService inputValidService, OutputView outputView) {
		this.inputView = inputView;
		this.inputValidService = inputValidService;
		this.outputView = outputView;
	}

	public Integer getBridgeSize() {
		try {
			return inputValidService.validBridgeSize(inputView.readBridgeSize());
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return getBridgeSize();
		}
	}

}
