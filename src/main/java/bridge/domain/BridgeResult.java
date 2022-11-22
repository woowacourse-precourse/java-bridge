package bridge.domain;

public class BridgeResult {
	final String WRONG = "X";
	private final String result;
	private final int count;
	private final boolean isClear;

	public BridgeResult(String result, int count) {
		this.result = result;
		this.count = count;
		this.isClear = isClearGame(result);
	}

	public String getResult() {
		return result;
	}

	public int getCount() {
		return count;
	}

	public boolean getIsClear() {
		return isClear;
	}

	private boolean isClearGame(String result) {
		boolean isClear = true;

		if (result.contains(WRONG)) {
			return false;
		}
		return isClear;
	}
}
