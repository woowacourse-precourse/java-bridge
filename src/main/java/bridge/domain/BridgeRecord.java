package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.GameRule;

public class BridgeRecord {
	private final List<String[]> boards;
	private int tryCount;

	public BridgeRecord() {
		boards= new ArrayList<>();
		tryCount=1;
	}

	public boolean addBoard(Bridge bridge, String board){
		List<String> bridgeBoards = bridge.getBoards();
		boolean success = true;

		if(bridgeBoards.get(boards.size()).equals(board)){
			boards.add(new String[]{board, GameRule.ANSWER_MARK});
		} else if (!bridgeBoards.get(boards.size()).equals(board)){
			boards.add(new String[]{board, GameRule.WRONG_MARK});
			success = false;
		}
		return success;
	}

	public void deleteBoard() {
		boards.remove(boards.size()-1);
	}

	public void increaseTry() {
		this.tryCount++;
	}

	public List<String[]> getBoards() {
		return boards;
	}

	public int getTryCount() {
		return tryCount;
	}
}
