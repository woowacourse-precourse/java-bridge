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
		upLog = new ArrayList<>();
		downLog = new ArrayList<>();
		tryAttempts = 1;
	}

	void recordSuccess(String direction) {
		final String SUCCESS = "O";
		if (direction.equals(Constants.UP)) {
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

	void recordFail(String direction) {
		final String FAIL = "X";
		if (direction.equals(Constants.UP)) {
			recordUpLog(FAIL);
			return;
		}
		recordDownLog(FAIL);
	}

	@Override
	public String toString() {
		return logToString(upLog) + "\n" + logToString(downLog);
	}

	private String logToString(List<String> log) {
		String PREFIX = "[ ";
		String DELIMITER = " | ";
		String SUFFIX = " ]";
		return PREFIX + String.join(DELIMITER, log) + SUFFIX;
	}
}
