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
	
	public String getMap() {
		String bridgeMap = "[" + upperBridge.toString()	+ "]\n"
				+ "[" + lowerBridge.toString() + "]";
		
		return bridgeMap;
	}
}
