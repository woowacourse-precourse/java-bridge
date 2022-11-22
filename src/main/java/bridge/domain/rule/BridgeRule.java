package bridge.domain.rule;

public class BridgeRule {

	private static final int START_SIZE = 3;
	private static final int END_SIZE = 20;
	private static final String UP = "U";
	private static final String DOWN = "D";
	private static final String RETRY = "R";
	private static final String QUIT = "Q";


	public void isInRange(int input) {
		if (input < START_SIZE || input > END_SIZE) {
			throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
		}
	}
}
