package bridge.domain.player;

import bridge.view.InputException;
import bridge.view.InputValidator;

public class GameProceedCommand implements InputValidator {

	public static final String RETRY = "R";
	public static final String QUIT = "Q";

	private final String gameCommand;

	public GameProceedCommand(String gameCommand) {
		validate(gameCommand);
		this.gameCommand = gameCommand;
	}

	public static GameProceedCommand valueOf(String gameCommand) {
		return new GameProceedCommand(gameCommand);
	}

	@Override
	public void validate(String inputGameCommand) {
		isAssignedCommand(inputGameCommand);
	}

	private void isAssignedCommand(String gameCommand) {
		if (!gameCommand.equals(RETRY) && !gameCommand.equals(QUIT)) {
			throw new InputException(InputException.GAME_COMMAND_NOT_ASSIGNED_COMMAND);
		}
	}

	public String getGameCommand() {
		return gameCommand;
	}

	@Override
	public void validate(Integer value) {
	}
}
