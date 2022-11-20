package domain;

import java.util.List;

import service.InputView;
import service.OutputView;

public class MapMaker {
	private InputView in = new InputView();
	private OutputView out = new OutputView();
	
	private final List<String> bridge;
	private StringBuilder upperBridge, lowerBridge;
	
	public MapMaker(List<String> bridge) {
		this.bridge = bridge;
		upperBridge = new StringBuilder();
		lowerBridge = new StringBuilder();
		
	}
	
	private boolean conditionCheck(String rightCondition, String move) {
		String condition = BridgeCondition.WRONG.getCondition();
		
		if(rightCondition.equals(move)) {
			condition = BridgeCondition.RIGHT.getCondition();
			upOrDownCheck(move, condition);
			return true;
		}
		
		upOrDownCheck(move, condition);
		return false;
	}
	
	private void upOrDownCheck(String move, String condition) {
		if (move.equals("U")) {
			upperBridge.append(condition);
			lowerBridge.append(BridgeCondition.EMPTY.getCondition());
			
			return;
		}

		upperBridge.append(BridgeCondition.EMPTY.getCondition());
		lowerBridge.append(condition);
	}
	
	public String getMap() {
		String bridgeMap = "[" + upperBridge.toString()	+ "]\n"
				+ "[" + lowerBridge.toString() + "]";
		
		return bridgeMap;
	}
}
