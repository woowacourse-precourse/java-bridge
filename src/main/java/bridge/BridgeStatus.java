package bridge;

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
		upperCellBuilder.append("[");
		lowerCellBuilder.append("[");
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
			upperCellBuilder.append(" O ");
		}
		if (isDown(bridgeLetter)) {
			upperCellBuilder.append(" X ");
		}
		lowerCellBuilder.append("   ");
		endCell();
	}

	private void putConsecutiveUpperCell(String bridgeLetter) {
		deleteEndCell();
		if (isUp(bridgeLetter)) {
			upperCellBuilder.append("|").append(" O ");
		}
		if (isDown(bridgeLetter)) {
			upperCellBuilder.append("|").append(" X ");
		}
		lowerCellBuilder.append("|").append("   ");
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
			lowerCellBuilder.append(" O ");
		}
		if (isUp(bridgeLetter)) {
			lowerCellBuilder.append(" X ");
		}
		upperCellBuilder.append("   ");
		endCell();
	}

	private void putConsecutiveLowerCell(String bridgeLetter) {
		deleteEndCell();
		if (isDown(bridgeLetter)) {
			lowerCellBuilder.append("|").append(" O ");
		}
		if (isUp(bridgeLetter)) {
			lowerCellBuilder.append("|").append(" X ");
		}
		upperCellBuilder.append("|").append("   ");
		endCell();
	}

	private static boolean isUp(String Letter) {
		return Letter.equals("U");
	}

	private static boolean isDown(String Letter) {
		return Letter.equals("D");
	}

	private void putStatus() {
		status.put("UpperCell", getUpperCell());
		status.put("LowerCell", getLowerCell());
	}

	private String getUpperCell() {
		return upperCellBuilder.toString();
	}

	private String getLowerCell() {
		return lowerCellBuilder.toString();
	}

	private void endCell() {
		upperCellBuilder.append("]");
		lowerCellBuilder.append("]");
	}

	private void deleteEndCell() {
		upperCellBuilder.deleteCharAt(upperCellBuilder.length() - 1);
		lowerCellBuilder.deleteCharAt(lowerCellBuilder.length() - 1);
	}

	public boolean isSuccess() {
		boolean isFailUpperCell = getUpperCell().contains("X");
		boolean isFailLowerCell = getLowerCell().contains("X");
		return !isFailUpperCell && !isFailLowerCell;
	}

	public int getTotalGameCount() {
		int totalGameCount = 0;
		if (phase > 0) {
			totalGameCount = phase;
		}
		return totalGameCount;
	}
}
