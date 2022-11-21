package bridge;

import static bridge.Constants.*;

import java.util.HashMap;

public class BridgeStatus {
	private volatile static BridgeStatus uniqueInstance;
	private final StringBuilder upperCellBuilder = new StringBuilder();
	private final StringBuilder lowerCellBuilder = new StringBuilder();

	private final HashMap<String, String> status = new HashMap<>();
	private static int phase = 0;

	public static BridgeStatus getInstance() {
		if (uniqueInstance == null) {
			synchronized (BridgeStatus.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new BridgeStatus();
				}
			}
		}
		return uniqueInstance;
	}

	private BridgeStatus() {
		startCell();
	}

	private void startCell() {
		upperCellBuilder.append(START_BRACKET);
		lowerCellBuilder.append(START_BRACKET);
	}

	public HashMap<String, String> loadStatus(String userSelectedCell, String bridgeLetter) {
		if (isUp(userSelectedCell)) {
			buildUpperCell(bridgeLetter);
			putStatus();
		}
		if (isDown(userSelectedCell)) {
			buildLowerCell(bridgeLetter);
			putStatus();
		}
		return status;
	}

	private void buildUpperCell(String bridgeLetter) {
		if (phase == 0) {
			putFirstUpperCell(bridgeLetter);
		}
		if (phase > 0) {
			putConsecutiveUpperCell(bridgeLetter);
		}
		phase++;
	}

	private void putFirstUpperCell(String bridgeLetter) {
		if (isUp(bridgeLetter)) {
			upperCellBuilder.append(CORRECT_MARK);
		}
		if (isDown(bridgeLetter)) {
			upperCellBuilder.append(WRONG_MARK);
		}
		lowerCellBuilder.append(EMPTY);
		endCell();
	}

	private void putConsecutiveUpperCell(String bridgeLetter) {
		deleteEndCell();
		if (isUp(bridgeLetter)) {
			upperCellBuilder.append(VERTICAL_BAR).append(CORRECT_MARK);
		}
		if (isDown(bridgeLetter)) {
			upperCellBuilder.append(VERTICAL_BAR).append(WRONG_MARK);
		}
		lowerCellBuilder.append(VERTICAL_BAR).append(EMPTY);
		endCell();
	}

	private void buildLowerCell(String bridgeLetter) {
		if (phase == 0) {
			putFirstLowerCell(bridgeLetter);
		}
		if (phase > 0) {
			putConsecutiveLowerCell(bridgeLetter);
		}
		phase++;
	}

	private void putFirstLowerCell(String bridgeLetter) {
		if (isDown(bridgeLetter)) {
			lowerCellBuilder.append(CORRECT_MARK);
		}
		if (isUp(bridgeLetter)) {
			lowerCellBuilder.append(WRONG_MARK);
		}
		upperCellBuilder.append(EMPTY);
		endCell();
	}

	private void putConsecutiveLowerCell(String bridgeLetter) {
		deleteEndCell();
		if (isDown(bridgeLetter)) {
			lowerCellBuilder.append(VERTICAL_BAR).append(CORRECT_MARK);
		}
		if (isUp(bridgeLetter)) {
			lowerCellBuilder.append(VERTICAL_BAR).append(WRONG_MARK);
		}
		upperCellBuilder.append(VERTICAL_BAR).append(EMPTY);
		endCell();
	}

	private static boolean isUp(String Letter) {
		return Letter.equals(UP);
	}

	private static boolean isDown(String Letter) {
		return Letter.equals(DOWN);
	}

	private void putStatus() {
		status.put(UPPER_CELL, getUpperCell());
		status.put(LOWER_CELL, getLowerCell());
	}

	private String getUpperCell() {
		return upperCellBuilder.toString();
	}

	private String getLowerCell() {
		return lowerCellBuilder.toString();
	}

	private void endCell() {
		upperCellBuilder.append(END_BRACKET);
		lowerCellBuilder.append(END_BRACKET);
	}

	private void deleteEndCell() {
		upperCellBuilder.deleteCharAt(upperCellBuilder.length() - 1);
		lowerCellBuilder.deleteCharAt(lowerCellBuilder.length() - 1);
	}

	public boolean isSuccess() {
		boolean isFailUpperCell = getUpperCell().contains(WRONG_MARK);
		boolean isFailLowerCell = getLowerCell().contains(WRONG_MARK);
		return !isFailUpperCell && !isFailLowerCell;
	}

	public int getTotalGameCount() {
		int totalGameCount = 0;
		if (phase > 0) {
			totalGameCount = phase;
		}
		return totalGameCount;
	}

	public void reset() {
		phase = 0;
		upperCellBuilder.setLength(0);
		lowerCellBuilder.setLength(0);
		startCell();
	}
}
