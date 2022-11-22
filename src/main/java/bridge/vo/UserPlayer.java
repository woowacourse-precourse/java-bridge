package bridge.vo;

import java.util.ArrayList;
import java.util.List;

public class UserPlayer {
	private static UserPlayer userPlayer = null;
	private final List<String> moveRecord = new ArrayList<>();
	private int totalAttempt = 0;

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

	public boolean isCrossStep(Bridge bridge, int index) {
		String bridgePick = bridge.getIndexToCrossValue(index);
		String playerPick = moveRecord.get(index);
		return bridgePick.equals(playerPick);
	}

	public void initUserPlayInformation() {
		moveRecord.clear();
		totalAttempt++;
	}

	public List<String> getMoveRecord() {
		return moveRecord;
	}
}
