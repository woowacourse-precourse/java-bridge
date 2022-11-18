package validator;

public class MoveValidator {
	public static void validateMovingPath(String input) {
		if (!(input.equals("U") || input.equals("D"))) {
			throw new IllegalArgumentException("[ERROR] 이동할 칸은 'U'(위 칸) 또는 'D'(아래 칸)로 입력해야 합니다.");
		}
	}
}
