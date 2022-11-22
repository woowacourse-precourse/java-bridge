package bridge.utils;

public class MoveChecker {
	public static boolean isEqualToUp(String gameCommand) {
		return gameCommand.equals(MoveSymbols.UP);
	}

	public static boolean isEqualToDown(String gameCommand) {
		return gameCommand.equals(MoveSymbols.DOWN);
	}
}
