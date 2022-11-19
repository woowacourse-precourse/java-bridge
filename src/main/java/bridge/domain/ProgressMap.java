package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgressMap {
	private final List<List<String>> progressMap;

	public ProgressMap() {
		progressMap = new ArrayList<>();
		progressMap.add(new ArrayList<>());
		progressMap.add(new ArrayList<>());
	}

	public List<List<String>> getProgressMap() {
		return progressMap;
	}
}
