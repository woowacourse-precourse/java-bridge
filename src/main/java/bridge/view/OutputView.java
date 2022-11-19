package bridge.view;

import java.util.List;

public class OutputView {

	public boolean printMap(List<String> bridge, List<String> currentBridgeState) {
		String map = mapDraw(bridge, currentBridgeState);
		System.out.println(map + '\n');
		return isAnswer(bridge, currentBridgeState, currentBridgeState.size() - 1);
	}

	public boolean printFinalMapResult(List<String> bridge, List<String> currentBridgeState) {
		return printMap(bridge, currentBridgeState);
	}

	private String mapDraw(List<String> bridge, List<String> currentBridgeState) {
		StringBuilder upSb = new StringBuilder();
		StringBuilder downSb = new StringBuilder();
		sbBuilder(upSb, "[ ", downSb, "[ ");
		for (int position = 0; position < currentBridgeState.size(); position++) {
			upAndDownDraw(bridge, currentBridgeState, upSb, downSb, position);
			sbBuilder(upSb, "| ", downSb, "| ");
		}
		lastPositionDraw(upSb, downSb);
		return upSb.append('\n').append(downSb).toString();
	}

	private void lastPositionDraw(StringBuilder upSb, StringBuilder downSb) {
		upSb.delete(upSb.length() - 2, upSb.length());
		downSb.delete(downSb.length() - 2, downSb.length());
		sbBuilder(upSb, "]", downSb, "]");
	}

	//TODO : 리팩터링 - 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
	private static void upAndDownDraw(List<String> bridge, List<String> currentBridgeState, StringBuilder upSb,
		StringBuilder downSb, int position) {
		if (isUpper(currentBridgeState, position)) {
			drawUpPosition(bridge, currentBridgeState, upSb, downSb, position);
			return;
		}
		drawDownPosition(bridge, currentBridgeState, upSb, downSb, position);
	}

	private static void drawDownPosition(List<String> bridge, List<String> currentBridgeState, StringBuilder upSb,
		StringBuilder downSb, int position) {
		if (isAnswer(bridge, currentBridgeState, position)) {
			sbBuilder(upSb, "  ", downSb, "O ");
			return;
		}
		sbBuilder(upSb, "  ", downSb, "X ");
	}

	private static void drawUpPosition(List<String> bridge, List<String> currentBridgeState, StringBuilder upSb,
		StringBuilder downSb, int position) {
		if (isAnswer(bridge, currentBridgeState, position)) {
			sbBuilder(upSb, "O ", downSb, "  ");
			return;
		}
		sbBuilder(upSb, "X ", downSb, "  ");
	}

	private static void sbBuilder(StringBuilder upSb, String up, StringBuilder downSb, String down) {
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
