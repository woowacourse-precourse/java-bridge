package bridge.domain;

import bridge.Util;
import bridge.enums.BridgeFrame;
import bridge.enums.UpDown;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
	private final List<String> upSpace;
	private final List<String> downSpace;

	public BridgeMap(List<String> answerBridge, List<String> playerBridge) {
		this.upSpace = new ArrayList<>();
		this.downSpace = new ArrayList<>();
		initMap(answerBridge, playerBridge);
	}

	public void initMap(List<String> answerBridge, List<String> playerBridge) {
		for (int i = 0; i < playerBridge.size(); i++) {
			String answerDir = answerBridge.get(i);
			String playerDir = playerBridge.get(i);
			if (UpDown.isUp(answerDir)) {
				addBridgeSpace(upSpace, downSpace, Util.isSameString(answerDir, playerDir));
			} else if (UpDown.isDown(answerDir)) {
				addBridgeSpace(downSpace, upSpace, Util.isSameString(answerDir, playerDir));
			}
		}
	}

	private void addBridgeSpace(List<String> target, List<String> nonTarget, boolean isSameDirection) {
		nonTarget.add(BridgeFrame.BLANK.getValue());
		if (isSameDirection) {
			target.add(BridgeFrame.TRUE.getValue());
			return;
		}
		target.add(BridgeFrame.FALSE.getValue());
	}

	public List<String> getMap() {
		return List.of(getBridgeFormat(upSpace), getBridgeFormat(downSpace));
	}

	private String getBridgeFormat(List<String> space) {
		String separateSpace = String.join(BridgeFrame.DIV.getValue(), space);
		return BridgeFrame.FRONT.getValue() + separateSpace + BridgeFrame.BACK.getValue();
	}
}
