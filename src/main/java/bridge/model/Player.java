package bridge.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private List<String> myBridge;

	public Player() {
		myBridge = new ArrayList<>();
	}

	public boolean checkEnd(int endPosition) {
		return myBridge.size() == endPosition;
	}

	public void forward(String direction) {
		myBridge.add(direction);
	}

	public int getPosition() {
		return myBridge.size();
	}

	public List<String> getBridge() {
		return Collections.unmodifiableList(myBridge);
	}

//	public boolean isCorrectDirection(List<String> bridge, int idx) {
//		return bridge.get(idx) == myBridge.get(idx);
//	}
}
