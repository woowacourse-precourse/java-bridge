package bridge.controller;

import static bridge.controller.GameState.*;
import static bridge.view.ProgressMessage.*;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameInitialization;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.UserPlayer;

public class BridgeGameController {
	BridgeGameInitialization bridgeGameInitialization;
	BridgeGame bridgeGame;
	UserPlayer userPlayer = UserPlayer.getInstance();

	public BridgeGameController(BridgeGameInitialization bridgeGameInitialization) {
		this.bridgeGameInitialization = bridgeGameInitialization;
	}

	public void playBridgeGame() {
		startBridgeGame();
		GameState state;
		do {
			state = movePlayer();
			state = operateGame(state);

		} while (state.equals(CONTINUATION));
		finishGame(state);
	}

	private void startBridgeGame() {
		OutputView.printProgressMessage(GAME_START);
		OutputView.printProgressMessage(INPUT_BRIDGE_SIZE);
		bridgeGame = new BridgeGame(userPlayer, bridgeGameInitialization.initBridge());
	}

	private GameState movePlayer() {
		OutputView.printProgressMessage(CHOICE_MOVE_STEP);
		try {
			return bridgeGame.move(InputView.readMoving());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return movePlayer();
		}
	}

	public GameState operateGame(GameState inputState) {
		GameState state = inputState;
		if (inputState.equals(SELECT_GAME_COMMAND)) {
			state = isGameContinue();
		}
		return state;
	}

	private GameState isGameContinue() {
		OutputView.printProgressMessage(CHOICE_GAME_COMMAND);
		try {
			return bridgeGame.selectGameContinue(InputView.readGameCommand());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return isGameContinue();
		}
	}

	public void finishGame(GameState result) {
		OutputView.printProgressMessage(GAME_DRAW_RESULT);
		bridgeGame.draw(result);
	}
}
