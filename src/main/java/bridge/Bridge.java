package bridge;

import java.util.List;

/**
 *   - "U" 또는 "D"로 이루어져 있다.<p>
 */
public class Bridge {
	private final List<String> bridge;

	Bridge(List<String> bridge) {
		// Todo 예외처리
		this.bridge = bridge;
	}

	String getValueOfIndex(int index){
		return bridge.get(index);
	}
}
