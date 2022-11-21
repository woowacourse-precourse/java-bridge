package bridge;

import java.util.ArrayList;
import java.util.List;

import bridgeConstant.Constant;

public class MovingStack {

	private final List<String> movingStack = new ArrayList<>();

	public void addMoving(boolean isUpPosition) {
		if (isUpPosition) {
			movingStack.add(Constant.UPPER_POSITION);
		}
		if (!isUpPosition) {
			movingStack.add(Constant.LOWER_POSITION);
		}
	}

	public void clearMovingStack() {
		movingStack.clear();
	}

	public List<String> getMovingStack() {
		return movingStack;
	}

	public int getMovingCount() {
		int movingCount = movingStack.size();
		return movingCount;
	}
}
