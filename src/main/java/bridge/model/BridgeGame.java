package bridge.model;

import bridge.dto.GameResultDto;
import bridge.dto.MoveCommandDto;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private List<String> bridge;
	private int currentStep;
	private int totalTry;
	private boolean gameClear;

	public void initializeBridge(String bridgeLength) {
		if (UserInputExceptions.isNotValidLength(bridgeLength)) {
			throw new IllegalArgumentException(Messages.errorLength);
		}

		int convertedLength = Utils.convertBridgeLengthToNumber(bridgeLength);
		this.bridge = GameSetting.setBridgeForStartGame(convertedLength);
		currentStep = GameSetting.START_STEP;
		totalTry = GameSetting.FIRST_TRY;
		gameClear = GameSetting.GAME_FAIL;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public MoveCommandDto move(String moveCommand) {
		if (UserInputExceptions.isNotValidMove(moveCommand)) {
			throw new IllegalArgumentException(Messages.errorMovableCommand);
		}

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
	public GameResultDto retry(String endCommand) {
		if (UserInputExceptions.isNotValidEndCommand(endCommand)) {
			throw new IllegalArgumentException(Messages.errorEndCommand);
		}

		if (endCommand.equals("R")) {
			currentStep = GameSetting.START_STEP;
			totalTry++;
		}

		return GameSetting.setDataForRetryGame(totalTry, gameClear);
	}

	private int addStepIfMove(boolean moveFlag) {
		if (moveFlag) {
			return 1;
		}
		return 0;
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("다리의 정보 : ");
		for (String bridgeUnit : bridge) {
			sb.append(bridgeUnit).append(" ");
		}
		sb.append("\n");
		sb.append("다리의 길이 : ").append(bridge.size()).append("\n");

		sb.append("현재 다리에서의 위치 : ").append(currentStep).append(" \n총 시도횟수 : ").append(totalTry);
		sb.append("\n게임을 성공했습니까? : ").append(gameClear).append("\n");
		return sb.toString();
	}
}
