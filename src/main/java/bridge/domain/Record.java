package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
	private final List<List<String>> result = new ArrayList<>();

	public void recordResult(String move, Boolean moveResult) {
		if (moveResult == true) {
			result.add(List.of(move, "O"));
		}
		if (moveResult == false) {
			result.add(List.of(move, "X"));
		}
	}

	public List<List<String>> getResult() {
		return result;
	}
}
