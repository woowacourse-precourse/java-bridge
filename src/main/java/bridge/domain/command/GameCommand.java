package bridge.domain.command;

import java.util.Arrays;
import java.util.List;

public enum GameCommand {
	moveCommand(Arrays.asList("U", "D")),
	continueGameCommand(Arrays.asList("R", "Q"));

	private final List<String> gameCommand;

	GameCommand(List<String> gameCommand) {
		this.gameCommand = gameCommand;
	}

	public static String findMoveCommand(String inputCommand) {
		return findCommand(moveCommand.gameCommand, inputCommand);
	}

	public static boolean isContinueGame(String inputCommand) {
		String result = findCommand(continueGameCommand.gameCommand, inputCommand);
		return result.equals(continueGameCommand.gameCommand.get(0));
	}

	private static String findCommand(List<String> gameCommand, String inputCommand) {
		return gameCommand.stream().filter(command -> command.equals(inputCommand))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 안내문을 참고해 올바른 커맨드를 입력해주세요."));
	}
}
