package bridge.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MovableLocation {
	// 다리의 구성요소에서 값이 0이면 아래로 이동가능을 의미, 값이 1이면 위로 이동가능을 의미
	UP("U", 0), DOWN("D", 1);

	private final String movableSymbol;
	private final int movableNumber;

	MovableLocation(String movableSymbol, int movableNumber) {
		this.movableSymbol = movableSymbol;
		this.movableNumber = movableNumber;
	}

	public String getMovableSymbol() {
		return movableSymbol;
	}

	public int getMovableNumber() {
		return movableNumber;
	}

	public static String getMovableSymbolFromMovableNumber(int movable) {
		return Arrays.stream(values()).filter(symbol -> symbol.movableNumber == movable).findAny()
			.orElseThrow(NoSuchElementException::new).movableSymbol;
	}
}
