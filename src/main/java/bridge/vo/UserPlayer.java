package bridge.vo;

import java.util.ArrayList;
import java.util.List;

import bridge.validator.UserInputValidator;
import bridge.view.OutputView;

public class UserPlayer {
	private static UserPlayer userPlayer = null;
	private static final UserInputValidator userInputValidator = new UserInputValidator();
	private final List<String> moveRecord = new ArrayList<>();
	private Integer totalAttempt = 0;

	private UserPlayer() {
	}

	public static UserPlayer getInstance() {
		if (userPlayer == null) {
			userPlayer = new UserPlayer();
		}
		return userPlayer;
	}

	public boolean inputMovingDirection(String move) {
		try {
			userInputValidator.runMoveInputValidator(move);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean isCrossableStep(Bridge bridge) {
		int index = moveRecord.size() - 1;
		String bridgePick = bridge.getIndexToCrossValue(index);
		String playerPick = moveRecord.get(index);
		return bridgePick.equals(playerPick);
	}

	public void initMoveRecord() {
		moveRecord.clear();
	}
}
