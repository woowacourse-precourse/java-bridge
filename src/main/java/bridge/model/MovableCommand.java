package bridge.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MovableCommand {
	// 다리의 구성요소에서 값이 0이면 아래로 이동가능을 의미, 값이 1이면 위로 이동가능을 의미
	UP("U", 0), DOWN("D", 1);

	private final String movableCommandSymbol;
	private final int movableCommandNumber;

	MovableCommand(String movableCommandSymbol, int movableCommandNumber) {
		this.movableCommandSymbol = movableCommandSymbol;
		this.movableCommandNumber = movableCommandNumber;
	}

	public String getMovableCommandSymbol() {
		return movableCommandSymbol;
	}

	public int getMovableCommandNumber() {
		return movableCommandNumber;
	}

	public static String getMovableSymbolFromMovableNumber(int movable) {
		return Arrays.stream(values()).filter(symbol -> symbol.movableCommandNumber == movable)
			.findAny().orElseThrow(NoSuchElementException::new).movableCommandSymbol;
	}
}
