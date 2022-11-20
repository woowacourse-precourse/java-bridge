package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

	private final List<Move> selections;
	private int trialCount;

	public User() {
		selections = new ArrayList<>();
		trialCount = 1;
	}

	public void move(Move move) {
		selections.add(move);
	}

	public List<Move> getSelections() {
		return Collections.unmodifiableList(selections);
	}

	public int getCurrentSelectionIndex() {
		return selections.size() - 1;
	}

	public Move getCurrentSelection() {
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
