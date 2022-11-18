package bridge;

public class Bridge {
	// 'U' 또는 'D'가 저장됨. 어? 그럼 Enum 클래스로 Path를 만들어볼까..? 고민해보자.
	private final char path;

	public Bridge(char path) {
		this.path = path;
	}

	public boolean isRightPath(char chosenPath) {
		if (chosenPath == this.path) {
			return true;
		}

		return false;
	}
}
