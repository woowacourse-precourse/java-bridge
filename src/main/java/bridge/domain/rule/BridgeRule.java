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
	public int isNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
		}
	}
	public void isRetryCommand(String input){
		boolean isRetry = input.equals(RETRY) || input.equals(QUIT);
		if(!isRetry){
			throw new IllegalArgumentException("[ERROR] 재시도 R, 종료 Q를 입력해야 합니다.");
		}
	}
}
