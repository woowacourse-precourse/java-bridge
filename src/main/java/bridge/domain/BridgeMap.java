package bridge.domain;

import bridge.domain.dto.MovingResult;
import bridge.utils.Convertor;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
	List<MovingResult> map = new ArrayList<>();

	public void addResult(MovingResult movingResult) {
		map.add(movingResult);
	}

	public boolean isMovingSuccess(int currentLocation) {
		MovingResult movingResult = map.get(currentLocation);
		if (movingResult.getAnswer()) {
			return true;
		}
		return false;
	}

	public String getSplitMap(String splitDirection) {
		Convertor convertor = new Convertor();
		return convertor.joinSplitBridgeMap(splitDirection, this.map);
	}
}
