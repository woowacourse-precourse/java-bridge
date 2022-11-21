package bridge.vo;

import java.util.ArrayList;
import java.util.List;

public class UserPlayer {
	private static UserPlayer userPlayer = null;
	private final List<String> moveRecord = new ArrayList<>();
	private int totalAttempt;

	private UserPlayer() {
	}

	public static UserPlayer getInstance() {
		if (userPlayer == null) {
			userPlayer = new UserPlayer();
		}
		return userPlayer;
	}

	public void setMovingDirection(String move) {
		moveRecord.add(move);
	}

	public boolean isCrossableStep(Bridge bridge, int index) {
		String bridgePick = bridge.getIndexToCrossValue(index);
		String playerPick = moveRecord.get(index);
		return bridgePick.equals(playerPick);
	}

	public void initUserPlayInformation() {
		moveRecord.clear();
		totalAttempt += 1;
	}

	public List<String> showMoveRecord() {
		return moveRecord;
	}
}
