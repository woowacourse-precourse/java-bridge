package bridge.controller;

import bridge.service.InputValidService;
import bridge.view.InputView;

public class InputController {

	private final InputView inputView;
	private final InputValidService inputValidService;

	public InputController(InputView inputView, InputValidService inputValidService) {
		this.inputView = inputView;
		this.inputValidService = inputValidService;
	}

	public Integer getBridgeSize() {
		try {
			return inputValidService.validBridgeSize(inputView.readBridgeSize());
		} catch (IllegalArgumentException e) {
			return getBridgeSize();
		}
	}

}
