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
		if (userSelectedCell.equals("U")) {
			buildUpperCell(bridgeLetter);
			status.put("UpperCell", getUpperCell());
			status.put("LowerCell", getLowerCell());
		}
		if (userSelectedCell.equals("D")) {
			buildLowerCell(bridgeLetter);
			status.put("UpperCell", getUpperCell());
			status.put("LowerCell", getLowerCell());
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
		if (bridgeLetter.equals("U")) {
			upperCellBuilder.append(" O ");
		}
		if (!bridgeLetter.equals("U")) {
			upperCellBuilder.append(" X ");
		}
		lowerCellBuilder.append("   ");
		endCell();
	}

	private void putConsecutiveUpperCell(String bridgeLetter) {
		deleteEndCell();
		if (bridgeLetter.equals("U")) {
			upperCellBuilder.append("|").append(" O ");
		}
		if (!bridgeLetter.equals("U")) {
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
		if (bridgeLetter.equals("D")) {
			lowerCellBuilder.append(" O ");
		}
		if (!bridgeLetter.equals("D")) {
			lowerCellBuilder.append(" X ");
		}
		upperCellBuilder.append("   ");
		endCell();
	}

	private void putConsecutiveLowerCell(String bridgeLetter) {
		deleteEndCell();
		if (bridgeLetter.equals("D")) {
			lowerCellBuilder.append("|").append(" O ");
		}
		if (!bridgeLetter.equals("D")) {
			lowerCellBuilder.append("|").append(" X ");
		}
		upperCellBuilder.append("|").append("   ");
		endCell();
	}

	private void endCell() {
		upperCellBuilder.append("]");
		lowerCellBuilder.append("]");
	}

	private void deleteEndCell() {
		upperCellBuilder.deleteCharAt(upperCellBuilder.length() - 1);
		lowerCellBuilder.deleteCharAt(lowerCellBuilder.length() - 1);
	}

	private String getUpperCell() {
		return upperCellBuilder.toString();
	}

	private String getLowerCell() {
		return lowerCellBuilder.toString();
	}
}
