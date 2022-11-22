package bridge.utils;

public class CommandChecker {
	public static boolean isEqualToRetry(String gameCommand) {
		return gameCommand.equals(CommandSymbols.RETRY);
	}

	public static boolean isEqualToQuit(String gameCommand) {
		return gameCommand.equals(CommandSymbols.QUIT);
	}

	public static boolean isEqualToError(String gameCommand) {
		return gameCommand.equals(CommandSymbols.ERROR);
	}
}
