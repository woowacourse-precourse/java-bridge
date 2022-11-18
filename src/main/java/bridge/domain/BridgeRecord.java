package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeRecord {
	private final List<String> boards;

	public BridgeRecord() {
		boards= new ArrayList<>();
	}

	public void addBoard(String board){
		boards.add(board);
	}
}
