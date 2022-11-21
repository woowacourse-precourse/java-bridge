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

	private static boolean isUp(String Letter) {
		return Letter.equals(UP);
	}

	private static boolean isDown(String Letter) {
		return Letter.equals(DOWN);
	}

	private void buildUpperCell(String bridgeLetter) {
		if (phase == 0) {
			putFirstUpperCell(bridgeLetter);
		}
		if (phase > 0) {
			putMultipleUpperCell(bridgeLetter);
		}
		phase++;
	}

	private void putFirstUpperCell(String bridgeLetter) {
		putMarkByLetterInUpperCell(bridgeLetter);
		endCell();
	}

	private void endCell() {
		upperCellBuilder.append(END_BRACKET);
		lowerCellBuilder.append(END_BRACKET);
	}

	private void putMarkByLetterInUpperCell(String bridgeLetter) {
		if (isUp(bridgeLetter)) {
			upperCellBuilder.append(CORRECT_MARK);
		}
		if (isDown(bridgeLetter)) {
			upperCellBuilder.append(WRONG_MARK);
		}
		lowerCellBuilder.append(EMPTY);
	}

	private void putMultipleUpperCell(String bridgeLetter) {
		deleteEndCell();
		putMarkByLetterWhenHasMultipleUpperCell(bridgeLetter);
		endCell();
	}

	private void deleteEndCell() {
		upperCellBuilder.deleteCharAt(upperCellBuilder.length() - 1);
		lowerCellBuilder.deleteCharAt(lowerCellBuilder.length() - 1);
	}

	private void putMarkByLetterWhenHasMultipleUpperCell(String bridgeLetter) {
		if (isUp(bridgeLetter)) {
			upperCellBuilder.append(VERTICAL_BAR).append(CORRECT_MARK);
		}
		if (isDown(bridgeLetter)) {
			upperCellBuilder.append(VERTICAL_BAR).append(WRONG_MARK);
		}
		lowerCellBuilder.append(VERTICAL_BAR).append(EMPTY);
	}

	private void buildLowerCell(String bridgeLetter) {
		if (phase == 0) {
			putFirstLowerCell(bridgeLetter);
		}
		if (phase > 0) {
			putMultipleLowerCell(bridgeLetter);
		}
		phase++;
	}

	private void putFirstLowerCell(String bridgeLetter) {
		putMarkByLetterInLowerCell(bridgeLetter);
		endCell();
	}

	private void putMarkByLetterInLowerCell(String bridgeLetter) {
		if (isDown(bridgeLetter)) {
			lowerCellBuilder.append(CORRECT_MARK);
		}
		if (isUp(bridgeLetter)) {
			lowerCellBuilder.append(WRONG_MARK);
		}
		upperCellBuilder.append(EMPTY);
	}

	private void putMultipleLowerCell(String bridgeLetter) {
		deleteEndCell();
		putMarkByLetterWhenHasMultipleLowerCell(bridgeLetter);
		endCell();
	}

	private void putMarkByLetterWhenHasMultipleLowerCell(String bridgeLetter) {
		if (isDown(bridgeLetter)) {
			lowerCellBuilder.append(VERTICAL_BAR).append(CORRECT_MARK);
		}
		if (isUp(bridgeLetter)) {
			lowerCellBuilder.append(VERTICAL_BAR).append(WRONG_MARK);
		}
		upperCellBuilder.append(VERTICAL_BAR).append(EMPTY);
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

	public boolean isSuccess() {
		boolean containFailInUpperCell = getUpperCell().contains(WRONG_MARK);
		boolean containFailInLowerCell = getLowerCell().contains(WRONG_MARK);
		return !containFailInUpperCell && !containFailInLowerCell;
	}

	public void reset() {
		phase = 0;
		upperCellBuilder.setLength(0);
		lowerCellBuilder.setLength(0);
		startCell();
	}
}
