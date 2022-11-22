package bridge.dto;

public class GameCommand {
	private final String INVALID_INPUT_GAME_COMMAND = "[ERROR] R과 Q 중에서만 입력해야 합니다.\n";
	private final String RETRY_COMMAND = "R";
	private final String END_COMMAND = "Q";
	private String command;

	public GameCommand(String inputGameCommand) {
		validateGameCommand(inputGameCommand);
		this.command = inputGameCommand;
	}

	private void validateGameCommand(String inputGameCommand) {
		if (!inputGameCommand.equals(RETRY_COMMAND) && !inputGameCommand.equals(END_COMMAND)) {
			throw new IllegalArgumentException(INVALID_INPUT_GAME_COMMAND);
		}
	}

	public String getCommand() {
		return this.command;
	}
}
