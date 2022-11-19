package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	boolean isSuccess;
	int count = 1;

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 */
	public boolean move(List<String> subBridge, String moving) {
		isSuccess = subBridge.get(subBridge.size() - 1).equals(moving);
		return isSuccess;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 */
	public String retry(String gameCommand, String result) {
		if (gameCommand.equals("R")) {
			count++;
			return "";
		}
		return result;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public int getCount() {
		return count;
	}
}
