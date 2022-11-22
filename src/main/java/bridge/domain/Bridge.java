package bridge.domain;

import java.util.List;

import static bridge.Constants.DOWN;
import static bridge.Constants.UP;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		validate(bridge);
		this.bridge = bridge;
	}

	private void validate(List<String> bridge) {
		for (String status : bridge) {
			if (!status.equals(UP) && !status.equals(DOWN))
				throw new IllegalArgumentException();
		}
	}

	String getValueOfIndex(int index){
		return bridge.get(index);
	}
}
