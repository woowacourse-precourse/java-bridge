package bridge.service;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.command.BranchCommand;
import bridge.domain.ProgressMap;
import bridge.domain.command.MoveCommand;

public class BridgeGameService {
	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 20;
	private static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3이상, 20이하 입니다.";
	private final BridgeMaker bridgeMaker;

	public BridgeGameService() {
		this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	}

	public int checkBridgeSize(int size) {
		validSize(size);
		return size;
	}

	private void validSize(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
		}
	}

	public BridgeGame initBridgeGame(int size) {
		return new BridgeGame(bridgeMaker.makeBridge(size));
	}

	public ProgressMap initGameMap() {
		return new ProgressMap();
	}

	public String checkMoveCommand(String inputCommand) {
		MoveCommand command = MoveCommand.findCommand(inputCommand);
		return command.getValue();
	}

	public boolean retryOrEnd(String inputCommand) {
		BranchCommand branchCommand = BranchCommand.findCommand(inputCommand);
		return BranchCommand.isContinueGame(branchCommand);
	}
}
