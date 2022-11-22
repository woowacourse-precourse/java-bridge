package bridge.model;

import bridge.dto.GameResultDto;
import bridge.dto.MoveCommandDto;
import bridge.utils.CommandChecker;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private List<String> bridge;
	private int currentStep;
	private int totalTry;
	private boolean gameClear;

	public void startMakingBridge(String bridgeSize) {
		checkBridgeSizeError(bridgeSize);

		int convertedSize = BridgeSizeConverter.convertBridgeSize(bridgeSize);
		initializeBridge(convertedSize);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public MoveCommandDto move(String moveCommand) {
		checkMoveCommandError(moveCommand);

		boolean moveFlag = BridgeChecker.isMovableLocation(bridge, moveCommand, currentStep);
		currentStep += addStepIfMove(moveFlag);
		gameClear = BridgeChecker.isGameClear(bridge, currentStep);
		return new MoveCommandDto(moveCommand, moveFlag, gameClear);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry(String endCommand) {
		checkEndCommandError(endCommand);

		if (CommandChecker.isEqualToRetry(endCommand)) {
			currentStep = GameSetting.FIRST_STEP;
			totalTry++;
		}
	}

	public GameResultDto sendGameResult() {
		return new GameResultDto(totalTry, gameClear);
	}
	public void clearGameData() {
		bridge.clear();
		currentStep = 0;
		totalTry = 0;
		gameClear = false;
	}
	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("다리의 정보 : ");
		bridge.forEach(sb::append);
		sb.append("\n").append("다리의 길이 : ").append(bridge.size()).append("\n")
			.append("현재 다리에서의 위치 : ").append(currentStep).append(" \n총 시도횟수 : ").append(totalTry)
			.append("\n게임을 성공했습니까? : ").append(gameClear).append("\n");
		return sb.toString();
	}

	private void checkBridgeSizeError(String bridgeSize) {
		if (UserInputExceptions.isNotValidSize(bridgeSize)) {
			throw new IllegalArgumentException(BridgeErrorMessages.lengthError);
		}
	}

	private void initializeBridge(int convertedSize) {
		this.bridge = GameSetting.makeBridge(convertedSize);
		currentStep = GameSetting.FIRST_STEP;
		totalTry = GameSetting.FIRST_TRY;
		gameClear = GameSetting.GAME_FAIL;
	}

	private void checkMoveCommandError(String moveCommand) {
		if (UserInputExceptions.isNotValidMove(moveCommand)) {
			throw new IllegalArgumentException(BridgeErrorMessages.errorMovableCommand);
		}
	}

	private int addStepIfMove(boolean moveFlag) {
		if (moveFlag) {
			return 1;
		}
		return 0;
	}

	private void checkEndCommandError(String endCommand) {
		if (UserInputExceptions.isNotValidEndCommand(endCommand)) {
			throw new IllegalArgumentException(BridgeErrorMessages.errorEndCommand);
		}
	}
}
