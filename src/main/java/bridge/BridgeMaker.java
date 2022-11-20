package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridgeBoards = new ArrayList<>();
		while (size-- > 0) {
			makeBoard(bridgeBoards);
		}
		return bridgeBoards;
	}

	private void makeBoard(List<String> bridgeBoards) {
		int number = bridgeNumberGenerator.generate();

		if (number == 1) {
			bridgeBoards.add(GameRule.UP_BOARD);
		} else if (number == 0) {
			bridgeBoards.add(GameRule.DOWN_BOARD);
		}
	}
}
