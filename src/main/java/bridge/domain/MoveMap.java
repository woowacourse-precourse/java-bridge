package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveMap {
	private List<List<String>> moveMap = new ArrayList<>();

	public MoveMap() {
		moveMap.add(new ArrayList<>());
		moveMap.add(new ArrayList<>());
	}
}
