package bridge.model;

public class UserInputExceptions {
	public static boolean isNotValidSize(String size) {
		return isNotNumber(size) || isNotInRangeNumber(size);
	}

	public static boolean isNotValidMove(String movableCommand) {
		return isNotOneLength(movableCommand) || isNotValidMovableCommand(movableCommand);
	}

	public static boolean isNotValidEndCommand(String endCommand) {
		return isNotOneLength(endCommand) || isNotEndCommand(endCommand);
	}

	private static boolean isNotNumber(String size) {
		try {
			Integer.parseInt(size);
		} catch (IllegalArgumentException exception) {
			return true;
		}
		return false;
	}

	private static boolean isNotInRangeNumber(String size) {
		int number = Integer.parseInt(size);
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
