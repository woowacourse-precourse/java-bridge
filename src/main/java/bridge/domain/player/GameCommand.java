package bridge.domain.player;

import bridge.view.InputException;
import bridge.view.InputValidator;

public class GameCommand implements InputValidator {

	private final String gameCommand;
	public static final String COMMAND_RETRY = "R";
	public static final String COMMAND_QUIT = "Q";

	public GameCommand(String gameCommand) {
		validate(gameCommand);
		this.gameCommand = gameCommand;
	}

	public static GameCommand valueOf(String gameCommand) {
		return new GameCommand(gameCommand);
	}

	@Override
	public void validate(Object inputGameCommand) {
		isAssignedCommand((String) inputGameCommand);
	}

	private void isAssignedCommand(String gameCommand) {
		if (!gameCommand.equals(COMMAND_RETRY) && !gameCommand.equals(COMMAND_QUIT)) {
			throw new InputException(InputException.GAME_COMMAND_NOT_ASSIGNED_COMMAND);
		}
	}

	public String getGameCommand() {
		return gameCommand;
	}
}
