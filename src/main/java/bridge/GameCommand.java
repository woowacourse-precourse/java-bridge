package bridge;

import bridgeConstant.Constant;
import util.Validator;

public class GameCommand {
	private final String gameCommand;

	public GameCommand(String gameCommand) {
		Validator.validateGameCommand(gameCommand);
		this.gameCommand = gameCommand;
	}

	public boolean isRetry() {
		return gameCommand.equals(Constant.RESTART);
	}
}
