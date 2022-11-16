package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(List<Integer> bridge, List<Integer> inputMoveCommands) {
		String map = mapDraw(bridge, inputMoveCommands);
		System.out.println(map);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(List<Integer> bridge, List<Integer> inputMoveCommands) {
		printMap(bridge, inputMoveCommands);
	}

	private String mapDraw(List<Integer> bridge, List<Integer> inputMoveCommands) {
		StringBuilder upSb = new StringBuilder();
		StringBuilder downSb = new StringBuilder();
		sbBuilder(upSb, "[ ", downSb, "[ ");
		for (int position = 0; position < inputMoveCommands.size(); position++) {
			upAndDownDraw(bridge, inputMoveCommands, upSb, downSb, position);
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

	private static void upAndDownDraw(List<Integer> bridge, List<Integer> inputMoveCommands, StringBuilder upSb,
		StringBuilder downSb, int position) {
		if (isUpperInput(inputMoveCommands, position)) {
			drawUpPosition(bridge, inputMoveCommands, upSb, downSb, position);
			return;
		}
		drawDownPosition(bridge, inputMoveCommands, upSb, downSb, position);
	}

	private static void drawDownPosition(List<Integer> bridge, List<Integer> inputMoveCommands, StringBuilder upSb,
		StringBuilder downSb, int position) {
		if (isAnswer(bridge, inputMoveCommands, position)) {
			sbBuilder(upSb, "  ", downSb, "O ");
			return;
		}
		sbBuilder(upSb, "  ", downSb, "X ");
	}

	private static void drawUpPosition(List<Integer> bridge, List<Integer> inputMoveCommands, StringBuilder upSb,
		StringBuilder downSb, int position) {
		if (isAnswer(bridge, inputMoveCommands, position)) {
			sbBuilder(upSb, "O ", downSb, "  ");
			return;
		}
		sbBuilder(upSb, "X ", downSb, "  ");
	}

	private static void sbBuilder(StringBuilder upSb, String up, StringBuilder downSb, String down) {
		upSb.append(up);
		downSb.append(down);
	}

	private static boolean isUpperInput(List<Integer> inputMoveCommands, int position) {
		return inputMoveCommands.get(position) == 1;
	}

	private static boolean isAnswer(List<Integer> bridge, List<Integer> inputMoveCommands, int position) {
		return bridge.get(position).equals(inputMoveCommands.get(position));
	}

}
