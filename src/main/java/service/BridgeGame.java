package service;

import java.util.List;

import bridge.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSize;
import bridge.GameCommand;
import bridge.MoveResult;
import bridge.Moving;
import bridge.MovingStack;
import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MoveResultResponseDto;
import dto.MovingRequestDto;
import bridge.PlayCount;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private MovingStack movingStack;

	public void initMovingStack() {
		movingStack = new MovingStack();
	}

	/**
	 * 입력 받은 다리 길이로 다리를 생성하는 메서드
	 */
	public BridgeResponseDto initBridge(BridgeSizeRequestDto bridgeSizeRequestDto) {
		BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeSize bridgeSize = new BridgeSize(bridgeSizeRequestDto.getBridgeSize());
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
		return new BridgeResponseDto(new Bridge(bridge));
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 */
	public void move(MovingRequestDto movingRequestDto) {
		Moving moving = new Moving(movingRequestDto.getMoving());
		movingStack.addMoving(moving.isUpPosition());
	}

	private int calculateNumberOfCorrectMoving(MoveResultResponseDto moveResultResponseDto) {
		return (int)moveResultResponseDto.getMap().chars().filter(cell -> cell == 'O').count();
	}
	public boolean isEnd(BridgeResponseDto bridgeResponseDto, MoveResultResponseDto moveResultResponseDto) {
		List<String> bridge = bridgeResponseDto.getBridge();
		return calculateNumberOfCorrectMoving(moveResultResponseDto) != movingStack.getMovingCount() || bridge.equals(movingStack.getMovingStack());
	}

	public MoveResultResponseDto renderMap(BridgeResponseDto bridgeResponseDto) {
		List<String> bridge = bridgeResponseDto.getBridge();
		return new MoveResultResponseDto(new MoveResult(bridge, movingStack.getMovingStack()));
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 */
	public boolean retry(GameCommandRequestDto gameCommandRequestDto) {
		GameCommand gameCommand = new GameCommand(gameCommandRequestDto.getGameCommand());
		if (gameCommand.isRetry()) {
			PlayCount.getInstance().addCount();
			return true;
		}
		return false;
	}
}
