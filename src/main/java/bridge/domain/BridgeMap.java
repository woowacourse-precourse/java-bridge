package bridge.domain;

import bridge.enums.BridgeFrame;
import bridge.enums.UpDown;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
	private final List<String> answerBridge;
	private final List<String> upSpace;
	private final List<String> downSpace;
	private int position;

	public BridgeMap(List<String> answerBridge, List<String> playerBridge) {
		this.answerBridge = answerBridge;
		this.upSpace = new ArrayList<>();
		this.downSpace = new ArrayList<>();
		this.position = 0;
		initMap(playerBridge);
	}

	private void initMap(List<String> playerBridge) {
		playerBridge.forEach(this::addBlock);
	}

	public void addBlock(String direction) {
		if (UpDown.isUp(direction)) {
			addResultByTarget(upSpace, downSpace, direction);
			return ;
		}
		addResultByTarget(downSpace, upSpace, direction);
	}

	private void addResultByTarget(List<String> target, List<String> nonTarget, String direction) {
		nonTarget.add(BridgeFrame.BLANK.getValue());
		if (isRightDirection(direction)) {
			target.add(BridgeFrame.TRUE.getValue());
			return ;
		}
		target.add(BridgeFrame.FALSE.getValue());
	}

	private boolean isRightDirection(String direction) {
		return answerBridge.get(position++).equals(direction);
	}

	public List<String> getMap() {
		return List.of(getBridgeFormat(upSpace), getBridgeFormat(downSpace));
	}

	private String getBridgeFormat(List<String> space) {
		String separateSpace = String.join(BridgeFrame.DIV.getValue(), space);
		return BridgeFrame.FRONT.getValue() + separateSpace + BridgeFrame.BACK.getValue();
	}
}
