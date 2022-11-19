package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {
	private final List<List<String>> result = new ArrayList<>();

	public void recordOneMove(String move, Boolean moveResult) {
		addRecord(move, moveResult);
	}

	private void addRecord(String move, Boolean moveResult) {
		if (moveResult == true) {
			result.add(List.of(move, "O"));
			return;
		}
		result.add(List.of(move, "X"));
	}

	public List<List<String>> getResult() {
		return result;
	}

	public Boolean isSuccess() {
		return result.get(result.size() - 1).get(1).equals("O");
	}
}
