package bridge;

import bridge.dto.GameCommand;
import bridge.dto.Moving;
import bridge.utils.Controller.InputController;

public class BridgeGame {
	private final String RETRY = "R";
	private InputController inputController = new InputController();
	private User user;

	public BridgeGame(User user) {
		this.user = user;
	}

	public boolean move() {
		Moving moving = inputController.getMoving();
		return user.checkMoving(moving);
	}

	public boolean retry() {
		GameCommand gameCommand = inputController.getGameCommand();
		String command = gameCommand.getCommand();
		if (command.equals(RETRY)) {
			return true;
		}
		return false;
	}

	public boolean keepMove() {
		return user.isKeepMove();
	}

	public BridgeMap getBridgeMap() {
		return user.getBridgeMap();
	}

	public void resetGame() {
		user.resetGame();
	}
}
