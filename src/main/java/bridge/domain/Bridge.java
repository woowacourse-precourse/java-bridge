package bridge.domain;

public class Bridge {

	private final int length;

	public Bridge(int length) {
		validateLength(length);
		this.length = length;
	}

	private void validateLength(int length) {
		if (length < 3 || length > 20) {
			throw new IllegalArgumentException();
		}
	}
}
