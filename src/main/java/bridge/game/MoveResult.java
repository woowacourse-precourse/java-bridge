package bridge.game;

import bridge.io.ErrorMessage;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum MoveResult {
	CAN_MOVE("O", (inputCode, bridge) -> inputCode.equals(bridge)),
	CAN_NOT_MOVE("X", (inputCode, bridge) -> !inputCode.equals(bridge));

	private final String moveResultCode;
	private final BiFunction<String, String, Boolean> expression;

	MoveResult(String moveResultCode, BiFunction<String, String, Boolean> expression) {
		this.moveResultCode = moveResultCode;
		this.expression = expression;
	}

	private boolean canMove(String inputCode, String bridge) {
		return expression.apply(inputCode, bridge);
	}

	public String getMoveResultCode() {
		return moveResultCode;
	}

	public static MoveResult getMoveResultByInputCode(String inputCode, String bridgeCode) {
		return Arrays.stream(values())
				.filter(result -> result.canMove(inputCode, bridgeCode))
				.findAny()
				.orElseThrow(()->new IllegalStateException(ErrorMessage.ILLEGAL_STATE_ERROR_MESSAGE));
	}

//	public static MoveResult getMoveResultByMoveResultCode(String moveResultCode) {
//		return Arrays.stream(values())
//				.filter(result -> moveResultCode.equals(result.moveResultCode))
//				.findAny()
//				.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE));
//	}
}
