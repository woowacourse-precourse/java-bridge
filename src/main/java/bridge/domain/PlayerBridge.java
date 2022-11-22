package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerBridge {
	private final List<String> playerBridge;

	public PlayerBridge() {
		// todo 예외처리
		this.playerBridge = new ArrayList<>();
	}

	void init(){
		playerBridge.clear();
	}

	public void add(String move){
		playerBridge.add(move);
	}

	int getLastIndex(){
		return playerBridge.size() - 1;
	}

	String getLastValue(){
		return playerBridge.get(getLastIndex());
	}
}
