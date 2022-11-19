package bridge.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MoveCommand {
	// 다리의 구성요소에서 값이 0이면 아래로 이동가능을 의미, 값이 1이면 위로 이동가능을 의미
	UP("U", 0), DOWN("D", 1);

	private final String moveCommandSymbol;
	private final int moveCommandNumber;

	MoveCommand(String moveCommandSymbol, int moveCommandNumber) {
		this.moveCommandSymbol = moveCommandSymbol;
		this.moveCommandNumber = moveCommandNumber;
	}

	public String getMoveCommandSymbol() {
		return moveCommandSymbol;
	}

	public int getMoveCommandNumber() {
		return moveCommandNumber;
	}

	public static String getMovableSymbolFromMovableNumber(int movable) {
		return Arrays.stream(values()).filter(symbol -> symbol.moveCommandNumber == movable)
			.findAny().orElseThrow(NoSuchElementException::new).moveCommandSymbol;
	}
}
