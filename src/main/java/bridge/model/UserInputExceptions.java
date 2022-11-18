package bridge.model;

public class UserInputExceptions {
	public static boolean isNotValidLength(String length) {
		return isNotNumber(length) || isNotInRangeNumber(length);
	}

	public static boolean isNotValidMove(String movableCommand) {
		return isNotOneLength(movableCommand) || isNotValidMovableCommand(movableCommand);
	}

	public static boolean isNotValidEndCommand(String endCommand) {
		return isNotOneLength(endCommand) || isNotEndCommand(endCommand);
	}

	private static boolean isNotNumber(String length) {
		try {
			Integer.parseInt(length);
		} catch (IllegalArgumentException exception) {
			return true;
		}
		return false;
	}

	private static boolean isNotInRangeNumber(String length) {
		int number = Integer.parseInt(length);
		return number < 3 || number > 20;
	}


	private static boolean isNotOneLength(String movableCommand) {
		return movableCommand.length() != 1;
	}

	private static boolean isNotValidMovableCommand(String movableCommand) {
		return !movableCommand.equals("U") && !movableCommand.equals("D");
	}

	private static boolean isNotEndCommand(String endCommand) {
		return !endCommand.equals("Q") && !endCommand.equals("R");
	}
}
