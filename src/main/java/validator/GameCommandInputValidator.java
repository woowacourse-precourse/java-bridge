package validator;

import static view.InputViewConstants.ERROR_MESSAGE_WRONG_GAME_COMMAND_INPUT;
import static view.InputViewConstants.GAME_COMMAND_QUIT;
import static view.InputViewConstants.GAME_COMMAND_RESTART;

public class GameCommandInputValidator {
	
	public String validateGameCommand(String gameCommand) {
		if (gameCommand.equals(GAME_COMMAND_RESTART) || gameCommand.equals(GAME_COMMAND_QUIT)) {
			return gameCommand;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_GAME_COMMAND_INPUT);
	}
}
