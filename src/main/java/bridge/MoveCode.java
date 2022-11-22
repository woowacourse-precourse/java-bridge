package bridge;

import bridge.ErrorMessage;

import java.util.Arrays;

public enum MoveCode {
	DOWN("D", 0),
	UP("U", 1);

	private final String inputCode;
	private final int numberCode;

	MoveCode(String inputCode, int numberCode) {
		this.inputCode = inputCode;
		this.numberCode = numberCode;
	}

	public String getInputCode() {
		return inputCode;
	}

	public int getNumberCode() {
		return numberCode;
	}

	public static String getInputCodeByNumberCode(int numberCode) {
		return Arrays.stream(values())
				.filter(code -> code.numberCode == numberCode)
				.findAny()
				.map(MoveCode::getInputCode)
				.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE));
	}

	public static MoveCode getMoveCodeByInputCode(String inputCode) {
		return Arrays.stream(values())
				.filter(moveCode -> inputCode.equals(moveCode.inputCode))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE));
	}
}
