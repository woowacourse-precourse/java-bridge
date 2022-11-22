package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {

	public List<String> bridge = new ArrayList<>();
	public List<String> select = new ArrayList<>();
	public int moveCount = 0;
	public String isSuccess;
	public int tryCount = 1;

	public void addBridge(boolean movable) {
		if (movable) {
			bridge.add(BridgeSymbol.MOVABLE.getSymbol());
			return;
		}
		bridge.add(BridgeSymbol.UNMOVABLE.getSymbol());
	}

	public void addSelect(String moving) {
		select.add(moving);
	}

	public void clearInfo() {
		bridge.clear();
		select.clear();
		moveCount = 0;
	}

}
