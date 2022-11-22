package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.DOWN;
import static bridge.Constants.UP;

public class PlayerBridge {

	private final List<String> playerBridge;

	public PlayerBridge() {
		this.playerBridge = new ArrayList<>();
	}

	public void init() {
		playerBridge.clear();
	}

	public void add(String move) {
		validate(move);
		playerBridge.add(move);
	}

	private void validate(String move) {
		if (!move.equals(UP) && !move.equals(DOWN)) {
			throw new IllegalArgumentException();
		}
	}

	public int getLastIndex() {
		return playerBridge.size() - 1;
	}

	public String getLastValue() {
		return playerBridge.get(getLastIndex());
	}
}
