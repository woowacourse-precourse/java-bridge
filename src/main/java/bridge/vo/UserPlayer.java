package bridge.vo;

import java.util.ArrayList;
import java.util.List;

public class UserPlayer {
	private final List<String> moveRecord;
	private int totalAttempt;

	public UserPlayer() {
		moveRecord = new ArrayList<>();
		totalAttempt = 1;
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

	public int getTotalAttempt() {
		return totalAttempt;
	}
}
