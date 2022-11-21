package bridge.domain;

public class BridgeResult {
	private final String result;
	private final int count;
	private final boolean isClear;


	public BridgeResult(String result, int count, boolean isClear) {
		this.result = result;
		this.count = count;
		this.isClear = isClear;
	}

	public String getResult() {
		return result;
	}

	public int getCount() {
		return count;
	}

	public boolean isClear() {
		return isClear;
	}
}
