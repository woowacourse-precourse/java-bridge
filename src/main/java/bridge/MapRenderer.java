package bridge;

import java.util.List;

import bridgeConstant.Cell;

public class MapRenderer {
	public String render(List<String> subBridge, boolean isCorrectMoving) {
		StringBuilder upperRow = new StringBuilder();
		StringBuilder lowerRow = new StringBuilder();
		upperRow.append("[");
		lowerRow.append("[");
		for (int index = 0; index < subBridge.size(); index++) {
			if (index == subBridge.size() - 1) {
				if (isCorrectMoving) {
					if (subBridge.get(index).equals(Cell.upPosition())) {
						upperRow.append(" O ");
						lowerRow.append("   ");
					}
					if (subBridge.get(index).equals(Cell.downPosition())) {
						upperRow.append("   ");
						lowerRow.append(" O ");
					}
				}
				if (!isCorrectMoving) {
					if (subBridge.get(index).equals(Cell.upPosition())) {
						upperRow.append("   ");
						lowerRow.append(" X ");
					}
					if (subBridge.get(index).equals(Cell.downPosition())) {
						upperRow.append(" X ");
						lowerRow.append("   ");
					}
				}
				break;
			}
			if (subBridge.get(index).equals(Cell.upPosition())) {
				upperRow.append(" O ");
				lowerRow.append("   ");
			}
			if (subBridge.get(index).equals(Cell.downPosition())) {
				upperRow.append("   ");
				lowerRow.append(" O ");
			}
			upperRow.append("|");
			lowerRow.append("|");
		}
		upperRow.append("]");
		lowerRow.append("]");
		return upperRow + "\n" + lowerRow;
	}
}
