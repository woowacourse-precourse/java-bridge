package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameRule;

public class BridgeGame {

	private final Bridge bridge;
	private final BridgeRecord record;

	public BridgeGame(int size) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		this.bridge = new Bridge(bridgeMaker.makeBridge(size));
		this.record = new BridgeRecord();
	}

	public boolean move(String board) {
		return record.addBoard(bridge, board);
	}

	public boolean retry(String command) {
		if (command.equals(GameRule.RETRY_COMMAND)) {
			record.deleteBoard();
			record.increaseTry();
		} else if (command.equals(GameRule.QUIT_COMMAND)) {
			return true;
		}
		return false;
	}

	public boolean isFinish() {
		if (bridge.getBoards().size() == record.getBoards().size()) {
			return true;
		}
		return false;
	}

	public Bridge getBridge() {
		return bridge;
	}

	public BridgeRecord getRecord() {
		return record;
	}

}
