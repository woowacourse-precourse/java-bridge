package bridge.view;

import java.util.List;

public class OutputView {

	private static StringBuilder upSb = new StringBuilder();
	private static StringBuilder downSb = new StringBuilder();

	public boolean printMap(List<String> bridge, List<String> currentBridgeState) {
		String map = mapDraw(bridge, currentBridgeState);
		System.out.println(map + '\n');
		return isAnswer(bridge, currentBridgeState, currentBridgeState.size() - 1);
	}

	public boolean printFinalMapResult(List<String> bridge, List<String> currentBridgeState) {
		return printMap(bridge, currentBridgeState);
	}

	private String mapDraw(List<String> bridge, List<String> currentBridgeState) {
		upSb = new StringBuilder();
		downSb = new StringBuilder();
		sbBuilder("[ ", "[ ");
		for (int position = 0; position < currentBridgeState.size(); position++) {
			upAndDownDraw(bridge, currentBridgeState, position);
			sbBuilder("| ", "| ");
		}
		lastPositionDraw();
		return upSb.append('\n').append(downSb).toString();
	}

	private void lastPositionDraw() {
		upSb.delete(upSb.length() - 2, upSb.length());
		downSb.delete(downSb.length() - 2, downSb.length());
		sbBuilder("]", "]");
	}

	private static void upAndDownDraw(List<String> bridge, List<String> currentBridgeState, int position) {
		if (isUpper(currentBridgeState, position)) {
			drawUpPosition(bridge, currentBridgeState, position);
			return;
		}
		drawDownPosition(bridge, currentBridgeState, position);
	}

	private static void drawDownPosition(List<String> bridge, List<String> currentBridgeState, int position) {
		if (isAnswer(bridge, currentBridgeState, position)) {
			sbBuilder("  ", "O ");
			return;
		}
		sbBuilder("  ", "X ");
	}

	private static void drawUpPosition(List<String> bridge, List<String> currentBridgeState, int position) {
		if (isAnswer(bridge, currentBridgeState, position)) {
			sbBuilder("O ", "  ");
			return;
		}
		sbBuilder("X ", "  ");
	}

	private static void sbBuilder(String up, String down) {
		upSb.append(up);
		downSb.append(down);
	}

	private static boolean isUpper(List<String> currentBridgeState, int position) {
		return currentBridgeState.get(position).equals("U");
	}

	private static boolean isAnswer(List<String> bridge, List<String> currentBridgeState, int position) {
		return bridge.get(position).equals(currentBridgeState.get(position));
	}

}
