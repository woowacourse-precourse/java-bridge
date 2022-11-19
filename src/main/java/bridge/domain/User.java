package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	private final List<String> selections;
	private int trialCount;

	public User() {
		selections = new ArrayList<>();
		trialCount = 1;
	}

	public void move(String movePosition) {
		selections.add(movePosition);
	}

	public List<String> getSelections() {
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

	public void retry() {
		selections.clear();
		trialCount++;
	}

	public int getTrialCount() {
		return trialCount;
	}
}
