package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.GameRule;

public class BridgeRecord {
	private final List<String[]> boards;
	private int tryCount;

	public BridgeRecord() {
		boards= new ArrayList<>();
		tryCount=0;
	}

	public void addBoard(Bridge bridge, String board){
		List<String> bridgeBoards = bridge.getBoards();

		if(bridgeBoards.get(boards.size()).equals(board)){
			boards.add(new String[]{board, GameRule.ANSWER_MARK});
		} else if (!bridgeBoards.get(boards.size()).equals(board)){
			boards.add(new String[]{board, GameRule.WRONG_MARK});
		}
		tryCount++;
	}

	public List<String[]> getBoards() {
		return boards;
	}
}
