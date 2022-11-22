package bridge.domain;

import bridge.Constants;
import java.util.ArrayList;
import java.util.List;

public class GameRecord {
	private final String EMPTY = " ";

	private List<String> upLog;
	private List<String> downLog;
	private int tryAttempts;

	public GameRecord() {
		initLog();
		tryAttempts = 1;
	}

	private void initLog() {
		upLog = new ArrayList<>();
		downLog = new ArrayList<>();
	}

	public void recordSuccess(String moving) {
		final String SUCCESS = "O";
		if (moving.equals(Constants.UP)) {
			recordUpLog(SUCCESS);
			return;
		}
		recordDownLog(SUCCESS);
	}

	private void recordUpLog(String gameResult) {
		upLog.add(gameResult);
		downLog.add(EMPTY);
	}

	private void recordDownLog(String gameResult) {
		downLog.add(gameResult);
		upLog.add(EMPTY);
	}

	public void recordFail(String moving) {
		final String FAIL = "X";
		if (moving.equals(Constants.UP)) {
			recordUpLog(FAIL);
			return;
		}
		recordDownLog(FAIL);
	}

	public void retry() {
		initLog();
		tryAttempts++;
	}

	public int getTryAttempts() {
		return tryAttempts;
	}

	public List<String> getUpLog() {
		return upLog;
	}

	public List<String> getDownLog() {
		return downLog;
	}
}
