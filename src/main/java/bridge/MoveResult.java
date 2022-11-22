package bridge;

import java.util.List;

public class MoveResult {
	private static final int ONE = 1;
	private final boolean isSuccess;
	private final boolean isCorrect;

	public MoveResult(List<String> bridge, List<String> movingStack) {
		int lastIndex = movingStack.size() - ONE;
		this.isSuccess = bridge.equals(movingStack);
		this.isCorrect = bridge.get(lastIndex).equals(movingStack.get(lastIndex));
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
}
