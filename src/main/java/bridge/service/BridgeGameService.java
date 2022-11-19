package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.ProgressMap;

public class BridgeGameService {
	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 20;
	private static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
	private static final String MOVE_COMMAND_ERROR_MESSAGE = "[ERROR] 이동 커맨드는 U 또는 D 입니다.";
	private static final String RESTART_COMMAND_ERROR_MESSAGE = "[ERROR] 재시작, 종료 커맨드는 R 또는 Q 입니다.";
	private static final String UP_MOVE_COMMAND = "U";
	private static final String DOWN_MOVE_COMMAND = "D";
	private static final String RESTART_GAME_COMMAND = "R";
	private static final String QUIT_GAME_COMMAND = "Q";
	private final BridgeMaker bridgeMaker;

	public BridgeGameService() {
		this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	}

	public int checkBridgeSize(int size) {
		validSize(size);
		return size;
	}

	public BridgeGame initBridgeGame(int size) {
		return new BridgeGame(bridgeMaker.makeBridge(size));
	}

	public ProgressMap initGameMap() {
		return new ProgressMap();
	}

	public String checkMoveCommand(String moving) {
		validMoving(moving);
		return moving;
	}

	private void validSize(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
		}
	}

	private void validMoving(String moving) {
		if (!moving.equals(UP_MOVE_COMMAND) && !moving.equals(DOWN_MOVE_COMMAND)) {
			throw new IllegalArgumentException(MOVE_COMMAND_ERROR_MESSAGE);
		}
	}

	public boolean retryOrEnd(String command) {
		validCommand(command);
		return command.equals(RESTART_GAME_COMMAND);
	}

	private void validCommand(String command) {
		if (!command.equals(RESTART_GAME_COMMAND) && !command.equals(QUIT_GAME_COMMAND)) {
			throw new IllegalArgumentException(RESTART_COMMAND_ERROR_MESSAGE);
		}
	}
}
