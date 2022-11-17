package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	private final List<String> selections;
	private int tryCount;

	public User() {
		selections = new ArrayList<>();
		tryCount = 1;
	}

	public void move(String movePosition) {
		selections.add(movePosition);
	}

	public List<String> map() {
		return new ArrayList<>(selections);
	}

	public int getCurrentSelectionIndex() {
		return selections.size() - 1;
	}

	public String getCurrentSelection() {
		return selections.get(getCurrentSelectionIndex());
	}

	public int getSelectionCount() {
		return selections.size();
	}
}
