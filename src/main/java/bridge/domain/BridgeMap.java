package bridge.domain;

import bridge.utils.Convertor;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
	private final String NEVER_MOVE = "[ERROR] 다리에서 이동한 적이 없으므로 게임결과를 출력형식에 맞게 변경할 수 없습니다.";
	private final int MIN_MOVE_NUMBER = 1;

	List<MovingResult> map = new ArrayList<>();

	public boolean move(User user, Bridge bridge, int currentLocation) {
		MovingResult movingResult = user.selectMoving(currentLocation, bridge);
		map.add(movingResult);
		if (movingResult.isMovingSuccess()) {
			return true;
		}
		return false;
	}

	public List<String> getSplitMap() {
		validateIfMove();
		Convertor convertor = new Convertor();
		return convertor.convertSplitBridgeMap(map);
	}

	private void validateIfMove() {
		if (map.size() < MIN_MOVE_NUMBER) {
			throw new IllegalArgumentException(NEVER_MOVE);
		}
	}
}
