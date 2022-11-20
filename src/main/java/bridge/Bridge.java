package bridge;

import java.util.List;

/**
 *   - 0 또는 1로 이루어져 있다.<p>
 *   - 0이면 아래, 1이면 위가 건널 수 있는 길이라는 뜻이다.
 */
public class Bridge {
	private final List<Integer> bridge;

	Bridge(List<Integer> bridge) {
		this.bridge = bridge;
	}

}
