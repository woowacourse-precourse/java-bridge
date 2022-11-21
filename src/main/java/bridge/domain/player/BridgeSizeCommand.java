package bridge.domain.player;

import bridge.view.input.InputException;
import bridge.view.input.InputValidator;
import bridge.view.output.OutputView;

public class BridgeSizeCommand implements InputValidator {

	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

	private static final int BRIDGE_SIZE_MIN = 3;
	private static final int BRIDGE_SIZE_MAX = 20;

	private final int bridgeSize;

	public BridgeSizeCommand(int bridgeSize) {
		validate(bridgeSize);
		this.bridgeSize = bridgeSize;
	}

	@Override
	public void validate(Integer inputBridgeSize) {
		isNumberInBetween(inputBridgeSize);
	}

	public static BridgeSizeCommand valueOf(String inputBridgeSize) {
		OutputView.withContentOf(REQUEST_BRIDGE_SIZE, false, false).ConsoleMessage();
		try {
			return new BridgeSizeCommand(Integer.parseInt(inputBridgeSize));
		} catch (NumberFormatException e) {
			throw new InputException(InputException.NOT_A_NUMBER);
		}
	}

	private void isNumberInBetween(int inputBridgeLength) {
		if (inputBridgeLength < BRIDGE_SIZE_MIN || inputBridgeLength > BRIDGE_SIZE_MAX) {
			throw new InputException(String.format(InputException.NOT_IN_BETWEEN_PROPER_RANGE, BRIDGE_SIZE_MIN, BRIDGE_SIZE_MAX));
		}
	}

	public int bridgeSize() {
		return bridgeSize;
	}

	@Override
	public void validate(String value) {
	}
}
