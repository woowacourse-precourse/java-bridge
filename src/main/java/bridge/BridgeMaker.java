package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.command.MoveCommand;

public class BridgeMaker {

	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			int blockNumber = bridgeNumberGenerator.generate();
			bridge.add(createBridgeBlock(blockNumber));
		}
		return bridge;
	}

	private String createBridgeBlock(int blockNumber) {
		return MoveCommand.of(blockNumber);
	}
}
