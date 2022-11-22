package bridge.domain;

import java.util.List;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		// Todo 예외처리
		this.bridge = bridge;
	}

	String getValueOfIndex(int index){
		return bridge.get(index);
	}
}
