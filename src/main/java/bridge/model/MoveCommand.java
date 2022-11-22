package bridge.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MoveCommand {
	// 다리의 구성요소에서 값이 0이면 아래로 이동가능을 의미, 값이 1이면 위로 이동가능을 의미
	UP("U", 1), DOWN("D", 0);

	private final String symbol;
	private final int number;

	MoveCommand(String symbol, int number) {
		this.symbol = symbol;
		this.number = number;
	}

	public static String getSymbolFromNumber(int movable) {
		return Arrays.stream(values()).filter(symbol -> symbol.number == movable)
			.findAny().orElseThrow(NoSuchElementException::new).symbol;
	}
}
