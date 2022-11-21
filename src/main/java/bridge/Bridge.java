package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.enums.Inputs;

public class Bridge {

	private List<String> bridge;
	private List<Inputs> moveLog;
	private int nextPosition;

	public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		this.bridge = bridgeMaker.makeBridge(size);
		this.moveLog = new ArrayList<>();
		this.nextPosition = 0;
	}

	public boolean moveNext(Inputs move) {
		String correctMove = bridge.get(nextPosition);
		moveLog.add(move);
		if (correctMove == move.getMessage()) {
			nextPosition++;
			return true;
		}
		return false;
	}

	public boolean gameWon() {
		if (nextPosition >= bridge.size()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String upper = getOutputString(Inputs.MOVE_UP);
		String lower = getOutputString(Inputs.MOVE_DOWN);
		return upper + "\n" + lower;
	}

	private String getOutputString(Inputs target) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < moveLog.size(); i++) {
			String s = getMoveOutput(i, target);
			sb.append(" " + s + " |");
		}
		sb.setLength(sb.length()-1);
		return sb.append("]").toString();
	}

	private String getMoveOutput(int index, Inputs target) {
		Inputs move = moveLog.get(index);
		if (move == target && bridge.get(index).equals(move.getMessage())) {
			return "O";
		}
		if (move == target && !bridge.get(index).equals(move.getMessage())) {
			return "X";
		}
		return " ";
	}
	public List<String> getSuccessfullyMovedPartialBridge() {
		List<String> deepCopiedPartialBridge = new ArrayList<>();
		for (int i = 0; i < nextPosition; i++) {
			deepCopiedPartialBridge.add(bridge.get(i));
		}
		return deepCopiedPartialBridge;
	}

	public void resetMoveStatus() {
		this.nextPosition = 0;
		this.moveLog = new ArrayList<>();
	}
}
