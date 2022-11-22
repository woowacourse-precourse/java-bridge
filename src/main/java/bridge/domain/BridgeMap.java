package bridge.domain;

import bridge.utils.Convertor;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
	private final String NEVER_MOVE = "[ERROR] 이동결과가 없으므로 출력형식에 맞게 이동결과를 변환할 수 없습니다.\n";
	private final int MIN_MOVE_NUMBER = 1;

	List<MovingResult> map = new ArrayList<>();

	public void addMovingResult(MovingResult movingResult) {
		map.add(movingResult);
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
